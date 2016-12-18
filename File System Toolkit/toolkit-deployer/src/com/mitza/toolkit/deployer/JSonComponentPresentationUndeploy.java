package com.mitza.toolkit.deployer;

import com.mitza.toolkit.storage.StorageFactory;
import com.tridion.broker.StorageException;
import com.tridion.configuration.Configuration;
import com.tridion.configuration.ConfigurationException;
import com.tridion.deployer.ProcessingException;
import com.tridion.deployer.Processor;
import com.tridion.deployer.modules.ComponentPresentationUndeploy;
import com.tridion.transport.transportpackage.ComponentPresentationKey;
import com.tridion.transport.transportpackage.ProcessorInstructions;
import com.tridion.transport.transportpackage.TransportPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * File system deployer module that handles unpublish actions of Component Presentations
 *
 * @author Mihai Cadariu
 * @since 06.11.2015
 */
public class JSonComponentPresentationUndeploy extends ComponentPresentationUndeploy {

    private final Logger log = LoggerFactory.getLogger(JSonComponentPresentationUndeploy.class);

    public JSonComponentPresentationUndeploy(Configuration config, Processor processor) throws ConfigurationException {
        super(config, processor);
        log.debug("Create new instance");
    }

    /**
     * Called by the deployer framework when unpublishing a Component Presentation.
     * Triggers the removal of the Component Presentation JSON file.
     */
    @Override
    public void process(TransportPackage data) throws ProcessingException {
        ProcessorInstructions instructions = data.getProcessorInstructions();
        int publicationId = instructions.getPublicationId().getItemId();

        log.debug("Undeploy component presentation {}", data);
        long duration = System.currentTimeMillis();

        try {
            for (Object argument : instructions.getArgumentsCollection().getArguments()) {
                if (argument instanceof ComponentPresentationKey) {
                    ComponentPresentationKey key = (ComponentPresentationKey) argument;
                    int componentId = key.getComponentId().getItemId();
                    int templateId = key.getTemplateId().getItemId();
                    StorageFactory.INSTANCE.undeployComponentPresentation(publicationId, componentId, templateId);
                }
            }
        } catch (StorageException e) {
            log.error("Error while undeploying component presentation", e);
            throw new ProcessingException(e);
        }

        duration = System.currentTimeMillis() - duration;
        log.debug("Undeploy component presentation took {} millis", duration);
    }
}

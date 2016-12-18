package com.mitza.toolkit.deployer;

import com.mitza.toolkit.storage.StorageFactory;
import com.tridion.configuration.Configuration;
import com.tridion.configuration.ConfigurationException;
import com.tridion.deployer.ProcessingException;
import com.tridion.deployer.Processor;
import com.tridion.deployer.modules.ComponentPresentationDeploy;
import com.tridion.meta.ComponentPresentationMeta;
import com.tridion.transport.transportpackage.ComponentPresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * File system deployer module that handles publish actions of Component Presentations
 *
 * @author Mihai Cadariu
 * @since 06.11.2015
 */
public class JSonComponentPresentationDeploy extends ComponentPresentationDeploy {

    private final Logger log = LoggerFactory.getLogger(JSonComponentPresentationDeploy.class);

    public JSonComponentPresentationDeploy(Configuration config, Processor processor) throws ConfigurationException {
        super(config, processor);
        log.debug("Create new instance");
    }

    /**
     * Called by the deployer framework when publishing a Component Presentation.
     * Triggers the serialization of the Component Presentation into JSON.
     */
    @Override
    protected void processComponentPresentation(ComponentPresentation componentPresentation, File compPresFile) throws ProcessingException {
        ComponentPresentationMeta facade = componentPresentation.getComponentPresentationMetaFacade();
        int publicationId = facade.getPublicationId();

        log.debug("Deploy component presentation {}", componentPresentation);
        long duration = System.currentTimeMillis();

        int componentId = facade.getComponentId();
        int templateId = facade.getTemplateId();
        StorageFactory.INSTANCE.deployComponentPresentation(publicationId, componentId, templateId);

        duration = System.currentTimeMillis() - duration;
        log.debug("Deploy component presentation took {} millis", duration);
    }
}

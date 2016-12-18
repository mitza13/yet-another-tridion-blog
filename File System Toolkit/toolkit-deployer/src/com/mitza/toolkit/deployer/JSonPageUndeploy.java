package com.mitza.toolkit.deployer;

import com.mitza.toolkit.storage.StorageFactory;
import com.tridion.broker.StorageException;
import com.tridion.configuration.Configuration;
import com.tridion.configuration.ConfigurationException;
import com.tridion.deployer.ProcessingException;
import com.tridion.deployer.Processor;
import com.tridion.deployer.modules.PageUndeploy;
import com.tridion.transport.transportpackage.PageKey;
import com.tridion.transport.transportpackage.ProcessorInstructions;
import com.tridion.transport.transportpackage.TransportPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * File system deployer module that handles unpublish actions of Pages
 *
 * @author Mihai Cadariu
 * @since 06.11.2015
 */
public class JSonPageUndeploy extends PageUndeploy {

    private final Logger log = LoggerFactory.getLogger(JSonPageUndeploy.class);

    public JSonPageUndeploy(Configuration config, Processor processor) throws ConfigurationException {
        super(config, processor);
        log.debug("Create new instance");
    }

    /**
     * Called by the deployer framework when unpublishing a Page.
     * Triggers the removal of the Page JSON file.
     */
    @Override
    public void process(TransportPackage data) throws ProcessingException {
        ProcessorInstructions instructions = data.getProcessorInstructions();
        int publicationId = instructions.getPublicationId().getItemId();

        log.debug("Undeploy page {}", data);
        long duration = System.currentTimeMillis();

        try {
            for (Object argument : instructions.getArgumentsCollection().getArguments()) {
                if (argument instanceof PageKey) {
                    PageKey key = (PageKey) argument;
                    int pageId = key.getId().getItemId();
                    StorageFactory.INSTANCE.undeployPage(publicationId, pageId);
                }
            }
        } catch (StorageException e) {
            log.error("Error while undeploying page", e);
            throw new ProcessingException(e);
        }

        duration = System.currentTimeMillis() - duration;
        log.debug("Undeploy page took {} millis", duration);
    }
}

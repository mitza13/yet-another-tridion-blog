package com.mitza.toolkit.deployer;

import com.mitza.toolkit.storage.StorageFactory;
import com.tridion.broker.StorageException;
import com.tridion.configuration.Configuration;
import com.tridion.configuration.ConfigurationException;
import com.tridion.deployer.ProcessingException;
import com.tridion.deployer.Processor;
import com.tridion.deployer.modules.ComponentDeploy;
import com.tridion.transport.transportpackage.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * File system deployer module that handles publish actions of Components
 *
 * @author Mihai Cadariu
 * @since 06.11.2015
 */
public class JSonComponentDeploy extends ComponentDeploy {

    private final Logger log = LoggerFactory.getLogger(JSonComponentDeploy.class);

    public JSonComponentDeploy(Configuration config, Processor processor) throws ConfigurationException {
        super(config, processor);
        log.debug("Create new instance");
    }

    /**
     * Called by the deployer framework when publishing a Component.
     * Triggers the serialization of the Component meta into JSON.
     */
    @Override
    protected void processComponent(Component component) throws ProcessingException {
        log.debug("Deploy component {}", component);
        long duration = System.currentTimeMillis();

        try {
            StorageFactory.INSTANCE.deployComponent(component);
        } catch (StorageException e) {
            log.error("Error while storing component meta", e);
            throw new ProcessingException(e);
        }

        duration = System.currentTimeMillis() - duration;
        log.debug("Deploy component took {} millis", duration);
    }
}

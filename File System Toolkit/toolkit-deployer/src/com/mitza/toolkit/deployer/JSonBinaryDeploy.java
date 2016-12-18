package com.mitza.toolkit.deployer;

import com.mitza.toolkit.storage.StorageFactory;
import com.tridion.broker.StorageException;
import com.tridion.configuration.Configuration;
import com.tridion.configuration.ConfigurationException;
import com.tridion.deployer.ProcessingException;
import com.tridion.deployer.Processor;
import com.tridion.deployer.modules.BinaryDeploy;
import com.tridion.transport.transportpackage.Binary;
import com.tridion.util.TCMURI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * File system deployer module that handles publish actions of Multimedia Components
 *
 * @author Mihai Cadariu
 * @since 06.11.2015
 */
public class JSonBinaryDeploy extends BinaryDeploy {

    private final Logger log = LoggerFactory.getLogger(JSonBinaryDeploy.class);

    public JSonBinaryDeploy(Configuration config, Processor processor) throws ConfigurationException {
        super(config, processor);
        log.debug("Create new instance");
    }

    /**
     * Called by the deployer framework when publishing a Multimedia Component.
     * Triggers the serialization of the binary meta into JSON.
     */
    @Override
    protected void processBinary(Binary binary, File binaryFile, TCMURI schemaTargetTCMURI) throws ProcessingException {
        log.debug("Deploy binary {}", binary);
        long duration = System.currentTimeMillis();

        try {
            StorageFactory.INSTANCE.deployBinary(binary);
        } catch (StorageException e) {
            log.error("Error while storing binary meta", e);
            throw new ProcessingException(e);
        }

        duration = System.currentTimeMillis() - duration;
        log.debug("Deploy binary took {} millis", duration);
    }
}

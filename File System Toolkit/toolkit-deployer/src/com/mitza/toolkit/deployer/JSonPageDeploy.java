package com.mitza.toolkit.deployer;

import com.mitza.toolkit.storage.StorageFactory;
import com.tridion.configuration.Configuration;
import com.tridion.configuration.ConfigurationException;
import com.tridion.deployer.ProcessingException;
import com.tridion.deployer.Processor;
import com.tridion.deployer.modules.PageDeploy;
import com.tridion.transport.transportpackage.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * File system deployer module that handles publish actions of Pages
 *
 * @author Mihai Cadariu
 * @since 01.11.2015
 */
public class JSonPageDeploy extends PageDeploy {

    private final Logger log = LoggerFactory.getLogger(JSonPageDeploy.class);

    public JSonPageDeploy(Configuration config, Processor processor) throws ConfigurationException {
        super(config, processor);
        log.debug("Create new instance");
    }

    @Override
    protected void processPage(Page page, File pageFile) throws ProcessingException {
        log.debug("Deploy page {}", page);
        long duration = System.currentTimeMillis();

        StorageFactory.INSTANCE.deployPage(page);

        duration = System.currentTimeMillis() - duration;
        log.debug("Deploy page took {} millis", duration);
    }
}

package com.mitza.toolkit.test.dynamic;

import com.mitza.toolkit.domain.ComponentPresentationMeta;
import com.mitza.toolkit.dynamic.ComponentPresentationFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mihai Cadariu
 * @since 13.11.2015
 */
public class ComponentPresentationFactoryTest {

    private final Logger log = LoggerFactory.getLogger(ComponentPresentationFactoryTest.class);
    private final ComponentPresentationFactory factory = ComponentPresentationFactory.INSTANCE;

    public ComponentPresentationFactoryTest() {
//        long duration = System.currentTimeMillis();
//        log.debug("Start ComponentPresentationFactoryTest");

        warmupTest();

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< ComponentPresentationFactoryTest duration {} millis", duration);
    }

    private void warmupTest() {
        factory.getComponentPresentationWithHighestPriority(6, 1118);
    }

    public void loadTest() {
        factory.getComponentPresentationWithHighestPriority(6, 1151);
        factory.getComponentPresentation(6, 52, 1117);
    }

    public void runTest() {
        ComponentPresentationMeta dcpMeta = factory.getComponentPresentationWithHighestPriority(6, 1151);

        if (dcpMeta == null) {
            log.debug("Cannot find DCP");
        } else {
            log.debug("Found DCP " + dcpMeta);
        }

        dcpMeta = factory.getComponentPresentation(6, 52, 1117);

        if (dcpMeta == null) {
            log.debug("Cannot find DCP");
        } else {
            log.debug("Found DCP " + dcpMeta);
        }
    }
}

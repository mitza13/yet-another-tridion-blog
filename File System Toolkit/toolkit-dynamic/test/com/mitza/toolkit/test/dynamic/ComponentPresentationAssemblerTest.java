package com.mitza.toolkit.test.dynamic;

import com.mitza.toolkit.dynamic.ComponentPresentationAssembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mihai Cadariu
 * @since 20.11.2015
 */
public class ComponentPresentationAssemblerTest {

    private final Logger log = LoggerFactory.getLogger(ComponentPresentationAssemblerTest.class);
    private final ComponentPresentationAssembler assembler = ComponentPresentationAssembler.INSTANCE;

    public ComponentPresentationAssemblerTest() {
//        long duration = System.currentTimeMillis();
//        log.debug("Start ComponentPresentationAssemblerTest");

        warmupTest();

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< ComponentPresentationAssemblerTest duration {} millis", duration);
    }

    private void warmupTest() {
        assembler.getContent(6, 52, 1185);
    }

    public void runTest() {
        assembler.getContent(6, 1151, 1117);
    }
}

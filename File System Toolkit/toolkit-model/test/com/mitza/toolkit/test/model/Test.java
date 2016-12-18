package com.mitza.toolkit.test.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mihai Cadariu
 * @since 26.11.2015
 */
public class Test {
    private static final Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        long duration = System.currentTimeMillis();
        log.debug("Start tests");

        new IndexTest();

        duration = System.currentTimeMillis() - duration;
        log.debug("<<< Total tests duration {} millis", duration);
    }
}

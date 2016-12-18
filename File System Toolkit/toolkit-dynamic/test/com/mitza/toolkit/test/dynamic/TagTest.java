package com.mitza.toolkit.test.dynamic;

import com.mitza.toolkit.dynamic.TagFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mihai Cadariu
 * @since 17.12.2016
 */
public class TagTest {

    private final Logger log = LoggerFactory.getLogger(TagTest.class);

    public TagTest() {
        long duration = System.currentTimeMillis();
        log.debug("Start TagTest");

        runTest();

        duration = System.currentTimeMillis() - duration;
        log.debug("<<< TagTest duration {} millis", duration);
    }

    public void runTest() {
        String content = "some <mytag>quick brown fox</mytag> content";
        content = TagFactory.INSTANCE.executeTags(content);
        log.debug("Content after execution: {}", content);
    }
}

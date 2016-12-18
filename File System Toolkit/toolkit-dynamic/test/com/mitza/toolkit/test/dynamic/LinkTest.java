package com.mitza.toolkit.test.dynamic;

import com.mitza.toolkit.domain.Link;
import com.mitza.toolkit.dynamic.LinkFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mihai Cadariu
 * @since 13.11.2015
 */
public class LinkTest {

    private final Logger log = LoggerFactory.getLogger(LinkTest.class);
    private final LinkFactory linkFactory = LinkFactory.INSTANCE;

    public LinkTest() {
//        long duration = System.currentTimeMillis();
//        log.debug("Start LinkTest");

        runBinaryLinkTest();
        runComponentLinkTest();
        runPageLinkTest();

//        duration = System.currentTimeMillis() - duration;
//        log.debug("<<< LinkTest duration {} millis", duration);
    }

    public void runBinaryLinkTest() {
        Link link = linkFactory.getBinaryLink(6, 84);
//        if (link.isResolved()) {
//            log.debug("Resolved binary link {}", link.getUrl());
//        } else {
//            log.debug("Cannot resolve binary link");
//        }

        link = linkFactory.getBinaryLink(6, 84, "tcm:6-106-32");
//        if (link.isResolved()) {
//            log.debug("Resolved binary link with variant {}", link.getUrl());
//        } else {
//            log.debug("Cannot resolve binary link with variant");
//        }
    }

    public void runComponentLinkTest() {
        Link link = linkFactory.getComponentLink(6, 52);
//        if (link.isResolved()) {
//            log.debug("Resolved component link {}", link.getUrl());
//        } else {
//            log.debug("Cannot resolve component link");
//        }

        link = linkFactory.getComponentLink(6, 1138, 1118);
//        if (link.isResolved()) {
//            log.debug("Resolved component link {}", link.getUrl());
//        } else {
//            log.debug("Cannot resolve component link");
//        }
    }

    public void runPageLinkTest() {
        Link link = linkFactory.getPageLink(6, 55);
//        if (link.isResolved()) {
//            log.debug("Resolved page link {}", link.getUrl());
//        } else {
//            log.debug("Cannot resolve page link");
//        }
    }
}

package com.mitza.toolkit.dynamic;

import com.mitza.toolkit.domain.ComponentPresentationMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Singleton implementation providing the entry point into retrieval of Dynamic Component Presentations content.
 *
 * @author Mihai Cadariu
 * @since 17.11.2015
 */
public enum ComponentPresentationAssembler {

    INSTANCE;
    private final Logger log = LoggerFactory.getLogger(ComponentPresentationAssembler.class);
    private final ComponentPresentationFactory cpFactory;

    ComponentPresentationAssembler() {
        log.debug("Create new instance");

        cpFactory = ComponentPresentationFactory.INSTANCE;
    }

    /**
     * Return the content of the Dynamic Component presentation. Any tags inside the content would have been executed.
     *
     * @param publicationId int the Publication id identifying this DCP
     * @param componentId   int the Component item id identifying this DCP
     * @param templateId    int the Component Template item id identifying this DCP
     * @return String the DCP content with all tags resolved
     */
    public String getContent(int publicationId, int componentId, int templateId) {
        Object[] dcpParameters = {publicationId, componentId, templateId};
        log.debug("Retrieve component presentation content {}-{}-{}", dcpParameters);

        ComponentPresentationMeta dcp = cpFactory.getComponentPresentation(publicationId, componentId, templateId);
        if (dcp == null) {
            log.debug("Cannot find DCP {}-{}-{}", dcpParameters);
            return null;
        } else {
            String content = dcp.getContent();
            if (content == null) {
                log.debug("Retrieve null DCP content");
            } else {
                log.debug("Retrieve DCP content of size {} bytes", content.length());
            }

            content = TagFactory.INSTANCE.executeTags(content);

            return content;
        }
    }
}

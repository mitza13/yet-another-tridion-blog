package com.mitza.toolkit.dynamic;

import com.mitza.toolkit.configuration.ToolkitConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Singleton factory implementation that parses the content of a Dynamic Component Presentation, identifies tags and
 * triggers execution of the corresponding tag implementation class.
 *
 * @author Mihai Cadariu
 * @since 06.01.2016
 */
public enum TagFactory {

    INSTANCE;
    private final TagSupport[] tags;
    private final Logger log = LoggerFactory.getLogger(TagFactory.class);

    TagFactory() {
        log.debug("Create new instance");

        List<TagSupport> tagSupports = new ArrayList<>();
        String[] tagNames = ToolkitConfiguration.INSTANCE.getTagNames();
        String[] tagClasses = ToolkitConfiguration.INSTANCE.getTagClasses();

        for (int i = 0; i < tagNames.length; i++) {
            String tagName = tagNames[i];
            String tagClass = tagClasses[i];
            tagSupports.add(new TagSupport(tagName, tagClass));
        }

        tags = tagSupports.toArray(new TagSupport[tagSupports.size()]);
    }

    /**
     * Execute the tags within the given DCP content and return the resulting DCP content
     *
     * @param content String the DCP content to process
     * @return String the DCP content after tags execution
     */
    public String executeTags(String content) {
        StringBuffer result = null;
        StringBuffer buffer = new StringBuffer(content);

        for (TagSupport tag : tags) {
            result = new StringBuffer();
            Matcher matcher = tag.getPattern().matcher(buffer);
            while (matcher.find()) {
                log.debug("Found tag " + matcher.group());
                String tagBody = matcher.groupCount() > 0 ? matcher.group(1) : null;
                matcher.appendReplacement(result, tag.execute(tagBody));
            }
            matcher.appendTail(result);
            buffer = result;
        }

        return result == null ? content : result.toString();
    }
}

package com.mitza.toolkit.dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

/**
 * Class that associates a tag name with an class handler. It provides functionality to trigger tag execution.
 *
 * @author Mihai Cadariu
 * @since 06.01.2016
 */
public class TagSupport {

    private static final String TAG_PATTERN = "<%1$s[^>]*>(.*)</%1$s>";
    private final Logger log = LoggerFactory.getLogger(TagSupport.class);

    private final Pattern pattern;
    private final Class<? extends TagRenderer> clazz;

    /**
     * Create new instance by wrapping the given tag name and class handler
     *
     * @param name      String the tag name
     * @param className String the handler class name
     */
    public TagSupport(String name, String className) {
        try {
            this.pattern = Pattern.compile(String.format(TAG_PATTERN, name), Pattern.MULTILINE | Pattern.DOTALL);
            this.clazz = Class.forName(className).asSubclass(TagRenderer.class);
        } catch (ClassNotFoundException e) {
            log.error("Class " + className + " not found", e);
            throw new TagException(e);
        } catch (ClassCastException e) {
            log.error("Class " + className + " is not a TagRenderer", e);
            throw new TagException(e);
        }
    }

    /**
     * Triggers tag execution passing the current tag body as parameter
     *
     * @param tagBody String the current tag parameter
     * @return String the result of the execution (the tag output)
     */
    public String execute(String tagBody) {
        log.debug("Execute tag {} with body {}", clazz, tagBody);

        try {
            return clazz.newInstance().doTag(tagBody);
        } catch (IllegalAccessException | InstantiationException e) {
            log.error("Cannot instantiate " + clazz, e);
            throw new TagException(e);
        }
    }

    /**
     * Return a Pattern on the current tag name that can match this tag as an XML node.
     * Example: &lt;myTag&gt;my tag body&lt;/myTag&gt;
     *
     * @return Pattern the current tag matching Pattern
     */
    public Pattern getPattern() {
        return pattern;
    }
}

package com.mitza.toolkit.dynamic;

/**
 * Interface that defines the method and signature of a tag renderer.
 *
 * @author Mihai Cadariu
 * @since 06.01.2016
 */
public interface TagRenderer {

    /**
     * Execute method that performs the tag logic
     *
     * @param tagBody String the body of the current tag as defined in the DCP content
     * @return String the output of this tag
     */
    String doTag(String tagBody);
}

package com.mitza.toolkit.domain;

import com.mitza.util.TcmUri;

/**
 * Object representing a Tridion link
 *
 * @author Mihai Cadariu
 * @since 30.11.2015
 */
public interface Link {

    /**
     * Return whether this link has been resolved
     *
     * @return boolean true if this link has been resolved
     */
    boolean isResolved();

    /**
     * Return the URL of this link, if it was resolved
     *
     * @return String URL of this link; or null, otherwise
     */
    String getUrl();

    /**
     * Return the TcmUri of the target item, if case the link was resolved
     *
     * @return TcmUri of the target item, in case the link was resolved; or null, otherwise
     */
    TcmUri getTargetUri();
}

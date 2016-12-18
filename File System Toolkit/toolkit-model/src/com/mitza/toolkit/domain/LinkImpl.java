package com.mitza.toolkit.domain;

import com.mitza.util.TcmUri;

/**
 * Object representing a Tridion link
 *
 * @author Mihai Cadariu
 * @since 11.11.2015
 */
public class LinkImpl implements Link {

    private boolean resolved;
    private String url;
    private TcmUri targetUri;

    /**
     * Return whether this link has been resolved
     *
     * @return boolean true if this link has been resolved
     */
    @Override
    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    /**
     * Return the URL of this link, if it was resolved
     *
     * @return String URL of this link; or null, otherwise
     */
    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Return the TcmUri of the target item, if case the link was resolved
     *
     * @return TcmUri of the target item, in case the link was resolved; or null, otherwise
     */
    @Override
    public TcmUri getTargetUri() {
        return targetUri;
    }

    public void setTargetUri(TcmUri targetUri) {
        this.targetUri = targetUri;
    }

    /**
     * Return a human readable String representation of this LinkImpl
     *
     * @return String representation of this LinkImpl
     */
    @Override
    public String toString() {
        return String.format("Link[resolved=%s url=%s target=%s]", resolved, url, targetUri);
    }
}

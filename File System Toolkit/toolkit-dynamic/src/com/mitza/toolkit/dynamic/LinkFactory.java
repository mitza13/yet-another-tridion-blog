package com.mitza.toolkit.dynamic;

import com.mitza.toolkit.domain.ComponentMeta;
import com.mitza.toolkit.domain.ItemTypes;
import com.mitza.toolkit.domain.Link;
import com.mitza.toolkit.domain.LinkImpl;
import com.mitza.toolkit.domain.LinkInfo;
import com.mitza.toolkit.domain.PageMeta;
import com.mitza.toolkit.model.ModelFactory;
import com.mitza.util.TcmUri;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton factory implementation that provides Component, Page and Binary linking logic.
 *
 * @author Mihai Cadariu
 * @since 10.11.2015
 */
public enum LinkFactory {

    INSTANCE;
    private final Logger log = LoggerFactory.getLogger(LinkFactory.class);
    private final ModelFactory modelFactory;

    LinkFactory() {
        log.debug("Create new instance");

        modelFactory = ModelFactory.INSTANCE;
    }

    /**
     * Return a link to the given Component outside the context of a Page. As such, the resolved link,
     * if exists, cannot compute the relative distance to the target.
     *
     * @param publication int the Publication id identifying the target Component
     * @param component   int the Component item id identifying the target Component
     * @return Link link to the given Component
     */
    public Link getComponentLink(int publication, int component) {
        log.debug("Get component link publication: {}, component: {}", publication, component);

        return getComponentLink(new TcmUri(publication, component));
    }

    /**
     * Return a link to the given Component outside the context of a Page. As such, the resolved link,
     * if exists, cannot compute the relative distance to the target.
     *
     * @param componentUri String the TcmUri of the target Component
     * @return Link link to the given Component
     */
    public Link getComponentLink(String componentUri) {
        log.debug("Get component link tcmuri: {}", componentUri);

        return getComponentLink(new TcmUri(componentUri));
    }

    /**
     * Return a link to the given Component outside the context of a Page. As such, the resolved link,
     * if exists, cannot compute the relative distance to the target.
     *
     * @param componentUri TcmUri of the target Component
     * @return Link link to the given Component
     */
    public Link getComponentLink(TcmUri componentUri) {
        log.debug("Get component link tcmuri: {}", componentUri);

        LinkImpl result = new LinkImpl();
        if (componentUri == null || componentUri.getType() != ItemTypes.COMPONENT) {
            log.debug("No component link resolving for tcmuri {}", componentUri);
            return result;
        }

        ComponentMeta componentMeta = modelFactory.getModel(componentUri);
        if (componentMeta == null) {
            log.debug("Component {} is not published", componentUri);
            return result;
        }

        List<LinkInfo> linkInfos = componentMeta.getLinkInfos();
        if (linkInfos == null || linkInfos.size() == 0) {
            log.debug("No link found for component {}", componentUri);
            return result;
        }

        LinkInfo linkInfo = linkInfos.get(0);
        result.setResolved(true);
        result.setUrl(linkInfo.getUrl());
        result.setTargetUri(new TcmUri(componentUri.getPublicationId(), linkInfo.getPage(), ItemTypes.PAGE));

        log.debug("Retrieved component {}", result);
        return result;
    }

    /**
     * Return a link to the given Component relative to the given source Page.
     *
     * @param pageUri      String the TcmUri of the source Page the link appears on
     * @param componentUri String the TcmUri of the target Component
     * @return Link link to the given Component
     */
    public Link getComponentLink(String pageUri, String componentUri) {
        log.debug("Get component link from page: {} to component: {}", pageUri, componentUri);

        return getComponentLink(new TcmUri(pageUri), new TcmUri(componentUri));
    }

    /**
     * Return a link to the given Component relative to the given source Page.
     *
     * @param publication int the Publication id of the context repository
     * @param page        int source Page item id the link appears on
     * @param component   int the target Component item id
     * @return Link link to the given Component
     */
    public Link getComponentLink(int publication, int page, int component) {
        log.debug("Get component link in publication: {}, from page: {} to component: {}",
                new Object[]{publication, page, component});

        return getComponentLink(new TcmUri(publication, page, ItemTypes.PAGE), new TcmUri(publication, component));
    }

    /**
     * Return a link to the given Component relative to the given source Page.
     *
     * @param pageUri      TcmUri the source Page the link appears on
     * @param componentUri TcmUri the target Component
     * @return Link link to the given Component
     */
    public Link getComponentLink(TcmUri pageUri, TcmUri componentUri) {
        log.debug("Get component link from page: {} to component: {}", pageUri, componentUri);

        LinkImpl result = new LinkImpl();
        if (componentUri == null || componentUri.getType() != ItemTypes.COMPONENT) {
            log.debug("No component link resolving for tcmuri {}", componentUri);
            return result;
        }

        ComponentMeta componentMeta = modelFactory.getModel(componentUri);
        if (componentMeta == null) {
            log.debug("Component {} is not published", componentUri);
            return result;
        }

        List<LinkInfo> linkInfos = componentMeta.getLinkInfos();
        if (linkInfos == null || linkInfos.size() == 0) {
            log.debug("No link found for component {}", componentUri);
            return result;
        }

        String[] urlParts;
        PageMeta pageMeta = modelFactory.getModel(pageUri);
        if (pageMeta == null) {
            urlParts = new String[0];
        } else {
            urlParts = pageMeta.getUrl().split("/");
        }

        int pageId = pageUri.getItemId();
        int maxPriority = 1;
        int minDistance = Integer.MAX_VALUE;
        List<LinkInfo> filteredInfos = new ArrayList<>();

        for (LinkInfo linkInfo : linkInfos) {
            if (linkInfo.getPage() != pageId) {
                int distance = getDistance(urlParts, linkInfo.getUrl());
                int priority = linkInfo.getPriority();
                if (priority > maxPriority) {
                    maxPriority = priority;
                    minDistance = distance;
                    filteredInfos.clear();
                } else if (distance < minDistance) {
                    minDistance = distance;
                    filteredInfos.clear();
                }
                if (priority == maxPriority && distance == minDistance) {
                    filteredInfos.add(linkInfo);
                }
            }
        }

        LinkInfo linkInfo = getLastPublished(filteredInfos);
        if (linkInfo != null) {
            result.setResolved(true);
            result.setUrl(linkInfo.getUrl());
            result.setTargetUri(new TcmUri(componentUri.getPublicationId(), linkInfo.getPage(), ItemTypes.PAGE));
        }

        log.debug("Retrieved component {}", result);
        return result;
    }

    /**
     * Return a link to the given Page
     *
     * @param publication int the Publication id of the context repository
     * @param page        int the target Page item id
     * @return Link link to the given Page
     */
    public Link getPageLink(int publication, int page) {
        log.debug("Get page link publication: {}, page: {}", publication, page);

        return getPageLink(new TcmUri(publication, page, ItemTypes.PAGE));
    }

    /**
     * Return a link to the given Page
     *
     * @param pageUri String the TcmUri of the target Page
     * @return Link link to the given Page
     */
    public Link getPageLink(String pageUri) {
        log.debug("Get page link tcmuri: {}", pageUri);

        return getPageLink(new TcmUri(pageUri));
    }

    /**
     * Return a link to the given Page
     *
     * @param pageUri TcmUri of the target Page
     * @return Link link to the given Page
     */
    public Link getPageLink(TcmUri pageUri) {
        log.debug("Get page link tcmuri: {}", pageUri);

        LinkImpl result = new LinkImpl();
        if (pageUri == null || pageUri.getType() != ItemTypes.PAGE) {
            log.debug("No page link resolving for tcmuri {}", pageUri);
            return result;
        }

        PageMeta pageMeta = modelFactory.getModel(pageUri);
        if (pageMeta == null) {
            log.debug("Page {} is not published", pageUri);
            return result;
        }

        result.setResolved(true);
        result.setUrl(pageMeta.getUrl());
        result.setTargetUri(pageMeta.getTcmUri());

        log.debug("Retrieved page {}", result);
        return result;
    }

    /**
     * Return a link to the given Multimedia Component
     *
     * @param publication int the Publication id of the context repository
     * @param component   int the target Multimedia Component item id
     * @return Link link to the given Multimedia Component
     */
    public Link getBinaryLink(int publication, int component) {
        log.debug("Get binary link publication: {}, component: {}", publication, component);

        return getBinaryLink(new TcmUri(publication, component), null);
    }

    /**
     * Return a link to the given Multimedia Component
     *
     * @param publication int the Publication id of the context repository
     * @param component   int the target Multimedia Component item id
     * @param variant     String the binary variant to link to
     * @return Link link to the given Multimedia Component
     */
    public Link getBinaryLink(int publication, int component, String variant) {
        log.debug("Get binary link publication: {}, component: {}, variant: {}", new Object[]{publication, component, variant});

        return getBinaryLink(new TcmUri(publication, component), variant);
    }

    /**
     * Return a link to the given Multimedia Component
     *
     * @param componentUri String the target Multimedia Component TcmUri
     * @return Link link to the given Multimedia Component
     */
    public Link getBinaryLink(String componentUri) {
        log.debug("Get binary link tcmuri: {}", componentUri);

        return getBinaryLink(new TcmUri(componentUri), null);
    }

    /**
     * Return a link to the given Multimedia Component
     *
     * @param componentUri String the target Multimedia Component TcmUri
     * @param variant      String the binary variant to link to
     * @return Link link to the given Multimedia Component
     */
    public Link getBinaryLink(String componentUri, String variant) {
        log.debug("Get binary link componentUri: {}, variant: {}", componentUri, variant);

        return getBinaryLink(new TcmUri(componentUri), variant);
    }

    /**
     * Return a link to the given Multimedia Component
     *
     * @param componentUri TcmUri of the target Multimedia Component
     * @return Link link to the given Multimedia Component
     */
    public Link getBinaryLink(TcmUri componentUri) {
        log.debug("Get binary link tcmuri: {}", componentUri);

        return getBinaryLink(componentUri, null);
    }

    /**
     * Return a link to the given Multimedia Component
     *
     * @param componentUri TcmUri of the target Multimedia Component
     * @param variant      String the binary variant to link to
     * @return Link link to the given Multimedia Component
     */
    public Link getBinaryLink(TcmUri componentUri, String variant) {
        log.debug("Get binary link tcmuri: {}, variant: {}", componentUri, variant);

        LinkImpl result = new LinkImpl();
        if (componentUri == null || componentUri.getType() != ItemTypes.COMPONENT) {
            log.debug("No binary link resolving for tcmuri {}", componentUri);
            return result;
        }

        ComponentMeta componentMeta = modelFactory.getModel(componentUri);
        if (componentMeta == null) {
            log.debug("Component {} is not published", componentUri);
            return result;
        }

        if (!componentMeta.isMultimedia()) {
            log.debug("Component {} is not multimedia", componentUri);
            return result;
        }

        List<LinkInfo> linkInfos = componentMeta.getLinkInfos();
        if (linkInfos == null || linkInfos.size() == 0) {
            log.debug("No link found for component {}", componentUri);
            return result;
        }

        variant = variant == null ? "" : variant;

        for (LinkInfo linkInfo : linkInfos) {
            String linkVariant = linkInfo.getVariant();
            linkVariant = linkVariant == null ? "" : linkVariant;
            if (variant.equals(linkVariant)) {
                result.setResolved(true);
                result.setUrl(linkInfo.getUrl());
                result.setTargetUri(componentUri);
                break;
            }
        }

        log.debug("Retrieved binary {}", result);
        return result;
    }

    private int getDistance(String[] parts, String url) {
        int result = 0;

        String[] parts2 = url.split("/");
        int n = Math.min(parts.length, parts2.length) - 1;
        int i = 0;
        boolean loop = true;

        for (; i < n && loop; i++) {
            if (!parts[i].equals(parts2[i])) {
                loop = false;
                i--;
            }
        }

        result += parts.length - i - 1;
        result += parts2.length - i - 1;

        return result;
    }

    private LinkInfo getLastPublished(List<LinkInfo> linkInfos) {
        switch (linkInfos.size()) {
            case 0:
                return null;

            case 1:
                return linkInfos.get(0);

            default:
                long maxPublished = 0;
                LinkInfo result = linkInfos.get(0);

                for (LinkInfo linkInfo : linkInfos) {
                    TcmUri metaUri = new TcmUri(linkInfo.getPublication(), linkInfo.getPage(), ItemTypes.PAGE);
                    PageMeta pageMeta = modelFactory.getModel(metaUri);
                    if (pageMeta != null) {
                        long lastPublished = pageMeta.getLastPublished().getTime();
                        if (lastPublished > maxPublished) {
                            maxPublished = lastPublished;
                            result = linkInfo;
                        }
                    }
                }

                return result;
        }
    }
}

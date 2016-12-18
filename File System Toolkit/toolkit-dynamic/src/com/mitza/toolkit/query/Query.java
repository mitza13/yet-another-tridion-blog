package com.mitza.toolkit.query;

import com.mitza.toolkit.domain.ComponentMeta;
import com.mitza.toolkit.domain.ItemMeta;
import com.mitza.toolkit.domain.ItemTypes;
import com.mitza.toolkit.domain.PageMeta;
import com.mitza.toolkit.model.ModelFactory;
import com.mitza.util.TcmUri;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Entry point into the content query functionality. This triggers the query execution for Components, Pages or both.
 * It provides logic to filter the result set (by means of Criteria), sorting and pagination.
 *
 * @author Mihai Cadariu
 * @since 30.11.2015
 */
public class Query {

    private final Criterion criterion;
    private final ModelFactory modelFactory;
    private final Logger log = LoggerFactory.getLogger(Query.class);
    private Sorter sorter;
    private int page;
    private int pageSize;
    private int totalItemCount;

    /**
     * Create new instance using the given Criterion
     *
     * @param criterion Criterion used to perform query
     */
    public Query(Criterion criterion) {
        this.criterion = criterion;
        modelFactory = ModelFactory.INSTANCE;
    }

    /**
     * Execute current query and return TcmUris of the found items
     *
     * @return List of TcmUris for the found items
     */
    public List<String> executeQuery() {
        long duration = System.currentTimeMillis();
        log.debug("Execute uris query");

        List<String> uris = new ArrayList<>(criterion.executeQuery());

        if (sorter == null) {
            totalItemCount = uris.size();
            uris = applyPagination(uris);
        } else {
            // This is so inefficient. Use executeComponentQuery or executePageQuery instead if want to sort
            List<ItemMeta> models = new ArrayList<>(uris.size());

            for (String uri : uris) {
                TcmUri tcmUri = new TcmUri("tcm:" + uri);
                switch (tcmUri.getType()) {
                    case COMPONENT:
                        ComponentMeta componentMeta = modelFactory.getModel(tcmUri);
                        if (componentMeta != null) {
                            models.add(componentMeta);
                        }
                        break;

                    case PAGE:
                        PageMeta pageMeta = modelFactory.getModel(tcmUri);
                        if (pageMeta != null) {
                            models.add(pageMeta);
                        }
                        break;
                }
            }

            totalItemCount = models.size();
            Collections.sort(models, sorter);
            uris.clear();

            if (page == 0 && pageSize == 0) {
                for (ItemMeta model : models) {
                    uris.add(model.getTcmUri().toString());
                }
            } else {
                int offset = page <= 1 || pageSize <= 0 ? 0 : Math.min(models.size(), (page - 1) * pageSize);
                int limit = pageSize <= 0 ? 0 : Math.min(pageSize, models.size() - offset);
                log.debug("Apply pagination offset={} limit={}", offset, limit);

                for (int i = 0; i < limit; i++) {
                    ItemMeta model = models.get(offset + i);
                    uris.add(model.getTcmUri().toString());
                }
            }
        }

        duration = System.currentTimeMillis() - duration;
        log.debug("Execute uris query return {} in {} millis", uris, duration);
        return uris;
    }

    /**
     * Execute current query and return ComponentMeta models of the found items
     *
     * @return List of ComponentMeta models for the found items
     */
    public List<ComponentMeta> executeComponentQuery() {
        long duration = System.currentTimeMillis();
        log.debug("Execute component model query");

        List<String> uris = new ArrayList<>(criterion.executeQuery(new FilterImpl(ItemTypes.COMPONENT)));
        List<ComponentMeta> result;

        if (sorter == null) {
            totalItemCount = uris.size();
            uris = applyPagination(uris);
            result = new ArrayList<>(uris.size());

            for (String uri : uris) {
                TcmUri tcmUri = new TcmUri("tcm:" + uri);
                ComponentMeta componentMeta = modelFactory.getModel(tcmUri);
                if (componentMeta != null) {
                    result.add(componentMeta);
                }
            }
        } else {
            result = new ArrayList<>(uris.size());
            for (String uri : uris) {
                TcmUri tcmUri = new TcmUri("tcm:" + uri);
                ComponentMeta componentMeta = modelFactory.getModel(tcmUri);
                if (componentMeta != null) {
                    result.add(componentMeta);
                }
            }

            totalItemCount = result.size();
            Collections.sort(result, sorter);
            result = applyPagination(result);
        }

        duration = System.currentTimeMillis() - duration;
        log.debug("Execute component model query return {} in {} millis", result, duration);
        return result;
    }

    /**
     * Execute current query and return PageMeta models of the found items
     *
     * @return List of PageMeta models for the found items
     */
    public List<PageMeta> executePageQuery() {
        long duration = System.currentTimeMillis();
        log.debug("Execute page model query");

        List<String> uris = new ArrayList<>(criterion.executeQuery(new FilterImpl(ItemTypes.PAGE)));
        List<PageMeta> result = new ArrayList<>(uris.size());

        for (String uri : uris) {
            TcmUri tcmUri = new TcmUri("tcm:" + uri);
            PageMeta pageMeta = modelFactory.getModel(tcmUri);
            if (pageMeta != null) {
                result.add(pageMeta);
            }
        }
        totalItemCount = result.size();

        if (sorter != null) {
            Collections.sort(result, sorter);
        }

        result = applyPagination(result);

        duration = System.currentTimeMillis() - duration;
        log.debug("Execute page model query return {} in {} millis", result, duration);
        return result;
    }

    /**
     * Add sorting parameter on the given custom meta name and direction
     *
     * @param customMeta String the name of the cutom meta to sort on
     * @param direction  SortDirection enumeration indicating the sort direction
     */
    public void addSort(String customMeta, SortDirection direction) {
        if (sorter == null) {
            sorter = new Sorter(customMeta, direction);
        } else {
            sorter.addSort(customMeta, direction);
        }
        log.debug("Query {}", sorter);
    }

    /**
     * Add sorting parameter on the given sort property and direction
     *
     * @param column    SortColumn enumeration indicating the property to sort on
     * @param direction SortDirection enumeration indicating the sort direction
     */
    public void addSort(SortColumn column, SortDirection direction) {
        if (sorter == null) {
            sorter = new Sorter(column, direction);
        } else {
            sorter.addSort(column, direction);
        }
        log.debug("Query {}", sorter);
    }

    /**
     * Specify which page in the result set to return once the query executes
     *
     * @param page int the page number to return after query execution
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Specify the size of a page for pagination purposes
     *
     * @param pageSize int the number of items on a page
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Return the total number of items found by this query
     *
     * @return int the total number of items found after query execution
     */
    public int getTotalItemCount() {
        return totalItemCount;
    }

    private <T> List<T> applyPagination(List<T> items) {
        if (page == 0 && pageSize == 0) {
            return items;
        }

        int offset = page <= 1 || pageSize <= 0 ? 0 : Math.min(items.size(), (page - 1) * pageSize);
        int limit = pageSize <= 0 ? 0 : Math.min(pageSize, items.size() - offset);
        log.debug("Apply pagination offset={} limit={}", offset, limit);

        List<T> result = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++) {
            T item = items.get(offset + i);
            result.add(item);
        }

        return result;
    }
}

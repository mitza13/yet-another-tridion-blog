package com.tridion.cache;

import com.mihaiconsulting.cache.CacheNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DD4TDependencyTracker extends DependencyTracker {

    private final static Logger log = LoggerFactory.getLogger(DD4TDependencyTracker.class);

    public DD4TDependencyTracker(CacheProcessor cache, Region region) {
        super(cache, region);
        log.debug("Create new instance for region " + region);
    }

    @Override
    public void processPut(CacheElement element) throws CacheException {
        log.debug("Process put element: {}", element);
        super.processPut(element);
    }

    @Override
    public boolean processRemove(CacheElement element, boolean force) throws CacheException {
        log.debug("Process remove element: {}, force: {}", element, force);

        if (element != null) {
            String key = element.getKey().toString();
            CacheNotifier.getInstance().notify(key);
        }

        return super.processRemove(element, force);
    }

    @Override
    public void processFlush() throws CacheException {
        log.debug("Process flush");
        super.processFlush();
    }
}

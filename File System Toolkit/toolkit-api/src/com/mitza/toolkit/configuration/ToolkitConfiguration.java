package com.mitza.toolkit.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Singleton class that reads and makes available configuration values that are stored in the toolkit.properties file.
 *
 * @author Mihai Cadariu
 * @since 02.11.2015
 */
public enum ToolkitConfiguration {

    INSTANCE;
    public static final String CACHE_MONITOR_SECONDS = "cacheMonitorSeconds";
    public static final String CONTENT_ROOT = "contentRoot";
    public static final String CLEANUP = "cleanup";
    public static final String FILENAME = "toolkit.properties";
    public static final String JSON_ROOT = "jsonRoot";
    public static final String PRETTY_PRINT_JSON = "prettyPrintJson";
    public static final String CACHE_ENABLED = "cacheEnabled";
    public static final String CACHE_MAX_ENTRIES_LOCAL_HEAP = "cacheMaxEntriesLocalHeap";
    public static final String CACHE_TIME_TO_LIVE = "cacheTimeToLiveSeconds";
    public static final String CACHE_TIME_TO_IDLE = "cacheTimeToIdleSeconds";
    public static final String TAG_NAME = "tag.name.";
    public static final String TAG_CLASS = "tag.class.";

    private final Logger log = LoggerFactory.getLogger(ToolkitConfiguration.class);

    private boolean cacheEnabled;
    private int cacheMaxEntriesLocalHeap;
    private int cacheMonitorSeconds;
    private long cacheTimeToLiveSeconds;
    private long cacheTimeToIdleSeconds;
    private boolean cleanup;
    private String contentRoot;
    private String jsonRoot;
    private boolean prettyPrintJson;
    private boolean isWindows;
    private String[] tagNames;
    private String[] tagClasses;

    /**
     * Create singleton instance and read all configuration values from toolkit.properties
     */
    ToolkitConfiguration() {
        log.debug("Create new instance");
        InputStream input = null;

        try {
            input = ToolkitConfiguration.class.getClassLoader().getResourceAsStream(FILENAME);
            if (input == null) {
                String message = String.format("Unable to find resource '%s' in the classpath", FILENAME);
                log.error(message);
                throw new ConfigurationException(message);
            }

            Properties properties = new Properties();
            properties.load(input);

            setCleanup(properties.getProperty(CLEANUP));
            setContentRoot(properties.getProperty(CONTENT_ROOT));
            setJsonRoot(properties.getProperty(JSON_ROOT));
            setPrettyPrintJson(properties.getProperty(PRETTY_PRINT_JSON));
            setCacheEnabled(properties.getProperty(CACHE_ENABLED));
            setCacheMonitorSeconds(properties.getProperty(CACHE_MONITOR_SECONDS));
            setCacheMaxEntriesLocalHeap(properties.getProperty(CACHE_MAX_ENTRIES_LOCAL_HEAP));
            setCacheTimeToLiveSeconds(properties.getProperty(CACHE_TIME_TO_LIVE));
            setCacheTimeToIdleSeconds(properties.getProperty(CACHE_TIME_TO_IDLE));

            setTagNames(properties);
            setTagClasses(properties);

            setIsWindows();
        } catch (IOException ioe) {
            log.error("Error reading resource file " + FILENAME, ioe);
            throw new ConfigurationException(ioe);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ioe) {
                    log.error("Error closing input stream for resource file " + FILENAME, ioe);
                    throw new ConfigurationException(ioe);
                }
            }
        }
    }

    /**
     * Return the value in seconds of the cache monitor
     *
     * @return String representing the value in seconds of the cache monitor
     */
    public int getCacheMonitorSeconds() {
        return cacheMonitorSeconds;
    }

    /**
     * Set the value in seconds of the cache monitor
     *
     * @param cacheMonitorSeconds String representing the value in seconds of the cache monitor
     */
    public void setCacheMonitorSeconds(String cacheMonitorSeconds) {
        this.cacheMonitorSeconds = cacheMonitorSeconds == null ? 60 : Integer.parseInt(cacheMonitorSeconds);
        log.debug("Using {}={}", CACHE_MONITOR_SECONDS, this.cacheMonitorSeconds);
    }

    /**
     * Return whether cleanup is enabled
     *
     * @return boolean whether cleanup is enabled
     */
    public boolean isCleanup() {
        return cleanup;
    }

    /**
     * Set whether cleanup is enabled
     *
     * @param cleanup String whether cleanup is enabled
     */
    public void setCleanup(String cleanup) {
        this.cleanup = "true".equals(cleanup);
        log.debug("Using {}={}", CLEANUP, this.cleanup);
    }

    /**
     * Return the value of the content root folder
     *
     * @return String the value of the content root folder
     */
    public String getContentRoot() {
        return contentRoot;
    }

    /**
     * Set the value of the content root folder
     *
     * @param contentRoot String the value of the content root folder
     */
    private void setContentRoot(String contentRoot) {
        if (contentRoot == null) {
            contentRoot = File.separator;
        } else if (!contentRoot.endsWith(File.separator)) {
            contentRoot += File.separator;
        }

        this.contentRoot = contentRoot;
        log.debug("Using {}={}", CONTENT_ROOT, contentRoot);
    }

    /**
     * Return the value of the JSON root folder
     *
     * @return String the value of the JSON root folder
     */
    public String getJsonRoot() {
        return jsonRoot;
    }

    /**
     * Set the value of the JSON root folder
     *
     * @param jsonRoot String the value of the JSON root folder
     */
    private void setJsonRoot(String jsonRoot) {
        if (jsonRoot == null) {
            jsonRoot = File.separator;
        } else if (!jsonRoot.endsWith(File.separator)) {
            jsonRoot += File.separator;
        }

        this.jsonRoot = jsonRoot;
        log.debug("Using {}={}", JSON_ROOT, jsonRoot);
    }

    /**
     * Return whether JSON should be pretty-printed
     *
     * @return boolean whether JSON should be pretty-printed
     */
    public boolean isPrettyPrintJson() {
        return prettyPrintJson;
    }

    /**
     * Set whether JSON should be pretty-printed
     *
     * @param prettyPrintJson String whether JSON should be pretty-printed
     */
    public void setPrettyPrintJson(String prettyPrintJson) {
        this.prettyPrintJson = "true".equals(prettyPrintJson);
        log.debug("Using {}={}", PRETTY_PRINT_JSON, this.prettyPrintJson);
    }

    /**
     * Return whether current operating system is Windows
     *
     * @return boolean whether current operating system is Windows
     */
    public boolean isWindows() {
        return isWindows;
    }

    /**
     * Set whether current operating system is Windows
     */
    private void setIsWindows() {
        isWindows = System.getProperty("os.name", "win").toLowerCase().contains("win");
    }

    /**
     * Return the number of cache entries in the local heap
     *
     * @return int the number of cache entries in the local heap
     */
    public int getCacheMaxEntriesLocalHeap() {
        return cacheMaxEntriesLocalHeap;
    }

    /**
     * Set the number of cache entries in the local heap
     *
     * @param cacheMaxEntriesLocalHeap int the number of cache entries in the local heap
     */
    public void setCacheMaxEntriesLocalHeap(String cacheMaxEntriesLocalHeap) {
        this.cacheMaxEntriesLocalHeap = cacheMaxEntriesLocalHeap == null ? 10000 : Integer.parseInt(cacheMaxEntriesLocalHeap);
        log.debug("Using {}={}", CACHE_MAX_ENTRIES_LOCAL_HEAP, this.cacheMaxEntriesLocalHeap);
    }

    /**
     * Return the cache TTL in seconds
     *
     * @return int the cache TTL in seconds
     */
    public long getCacheTimeToLiveSeconds() {
        return cacheTimeToLiveSeconds;
    }

    /**
     * Set the cache TTL in seconds
     *
     * @param cacheTimeToLiveSeconds String the cache TTL in seconds
     */
    public void setCacheTimeToLiveSeconds(String cacheTimeToLiveSeconds) {
        this.cacheTimeToLiveSeconds = cacheTimeToLiveSeconds == null ? 3000 : Long.parseLong(cacheTimeToLiveSeconds);
        log.debug("Using {}={}", CACHE_TIME_TO_LIVE, this.cacheTimeToLiveSeconds);
    }

    /**
     * Return the cache time to idle in seconds
     *
     * @return int the cache time to idle in seconds
     */
    public long getCacheTimeToIdleSeconds() {
        return cacheTimeToIdleSeconds;
    }

    /**
     * Set the cache time to idle in seconds
     *
     * @param cacheTimeToIdleSeconds String the cache time to idle in seconds
     */
    public void setCacheTimeToIdleSeconds(String cacheTimeToIdleSeconds) {
        this.cacheTimeToIdleSeconds = cacheTimeToIdleSeconds == null ? 2000 : Long.parseLong(cacheTimeToIdleSeconds);
        log.debug("Using {}={}", CACHE_TIME_TO_IDLE, this.cacheTimeToIdleSeconds);
    }

    /**
     * Return an array with the configured tag names
     *
     * @return String[] array with the configured tag names
     */
    public String[] getTagNames() {
        return tagNames;
    }

    /**
     * Set the configured tag names
     *
     * @param properties Properties to read the tag names from
     */
    public void setTagNames(Properties properties) {
        tagNames = filterProperties(properties, TAG_NAME);
    }

    /**
     * Return an array with the configured tag class names
     *
     * @return String[] array with the configured tag class names
     */
    public String[] getTagClasses() {
        return tagClasses;
    }

    /**
     * Set the configured tag class names
     *
     * @param properties Properties to read the tag class names from
     */
    public void setTagClasses(Properties properties) {
        tagClasses = filterProperties(properties, TAG_CLASS);
    }

    /**
     * Return whether cache should be used
     *
     * @return boolean whether cache is enabled
     */
    public boolean isCacheEnabled() {
        return cacheEnabled;
    }

    /**
     * Set whether cache should be used
     *
     * @param cacheEnabled String whether cache is enabled
     */
    public void setCacheEnabled(String cacheEnabled) {
        this.cacheEnabled = !"false".equals(cacheEnabled); // default or missing => TRUE
        log.debug("Using {}={}", CACHE_ENABLED, this.cacheEnabled);
    }

    private String[] filterProperties(Properties properties, String filter) {
        int i = 1;
        List<String> names = new ArrayList<>();
        String name;

        while ((name = properties.getProperty(filter + i++)) != null) {
            names.add(name);
        }

        return names.toArray(new String[names.size()]);
    }
}
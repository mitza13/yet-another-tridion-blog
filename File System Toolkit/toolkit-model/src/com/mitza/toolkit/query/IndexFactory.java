package com.mitza.toolkit.query;

import com.mitza.toolkit.configuration.ToolkitConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Singleton factory implementation providing access to individual file indexes, such as Schema and custom meta indexes.
 *
 * @author Mihai Cadariu
 * @since 26.11.2015
 */
public enum IndexFactory {

    INSTANCE;
    private static final String SCHEMA_INDEX = "schema.index";
    private static final String CUSTOM_META_DATE_INDEX = "custom-date.index";
    private static final String CUSTOM_META_NUMERIC_INDEX = "custom-numeric.index";
    private static final String CUSTOM_META_STRING_INDEX = "custom-string.index";

    private final IndexAbstract customMetaDateIndex;
    private final IndexAbstract customMetaNumericIndex;
    private final IndexAbstract customMetaStringIndex;
    private final IndexAbstract schemaIndex;

    private final Logger log = LoggerFactory.getLogger(IndexFactory.class);

    IndexFactory() {
        log.debug("Create new instance");
        ToolkitConfiguration toolkitConfiguration = ToolkitConfiguration.INSTANCE;

        String rootPath = toolkitConfiguration.getJsonRoot();

        File file = null;
        try {
            file = new File(rootPath, CUSTOM_META_DATE_INDEX);
            File directory = file.getParentFile();
            if (!directory.exists()) {
                if (!directory.mkdirs()) {
                    log.error("Directory {} was not created", directory);
                }
            }
            file.createNewFile();
            customMetaDateIndex = new IndexImpl(file);

            file = new File(rootPath, CUSTOM_META_NUMERIC_INDEX);
            file.createNewFile();
            customMetaNumericIndex = new IndexImpl(file);

            file = new File(rootPath, CUSTOM_META_STRING_INDEX);
            file.createNewFile();
            customMetaStringIndex = new IndexImpl(file);

            file = new File(rootPath, SCHEMA_INDEX);
            file.createNewFile();
            schemaIndex = new IndexImpl(file);
        } catch (Exception e) {
            log.error("Error occurred while creating index file " + file, e);
            throw new IndexException(e);
        }
    }

    /**
     * Return the Schema index singleton
     *
     * @return IndexAbstract the Schema index object
     */
    public IndexAbstract getSchemaIndex() {
        return schemaIndex;
    }

    /**
     * Return the custom meta date values index singleton
     *
     * @return IndexAbstract the custom meta date index object
     */
    public IndexAbstract getCustomMetaDateIndex() {
        return customMetaDateIndex;
    }

    /**
     * Return the custom meta numeric values index singleton
     *
     * @return IndexAbstract the custom meta numeric index object
     */
    public IndexAbstract getCustomMetaNumericIndex() {
        return customMetaNumericIndex;
    }

    /**
     * Return the custom meta String values index singleton
     *
     * @return IndexAbstract the custom meta String index object
     */
    public IndexAbstract getCustomMetaStringIndex() {
        return customMetaStringIndex;
    }
}

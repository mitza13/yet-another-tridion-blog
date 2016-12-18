package com.mitza.toolkit.serializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Singleton factory implementation that provides acess to the configured JSON serializer.
 *
 * @author Mihai Cadariu
 * @since 03.11.2015
 */
public enum SerializerFactory {

    INSTANCE;
    private final Logger log = LoggerFactory.getLogger(SerializerFactory.class);
    private JSonSerializer serializer;

    SerializerFactory() {
        log.debug("Create new instance");

        setSerializer(new JSonSerializer());
    }

    /**
     * Return instance of the JSON serializer
     *
     * @return JSonSerializer the serializer to use
     */
    public JSonSerializer getSerializer() {
        return serializer;
    }

    private void setSerializer(JSonSerializer serializer) {
        log.debug("Using serializer={}", serializer);
        this.serializer = serializer;
    }
}

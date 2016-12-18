package com.mitza.toolkit.serializer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mitza.toolkit.configuration.ToolkitConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Serializer class using FasterXML Jackson implementation of JSON (de-)serializer that provides functionality to
 * serialize and deserialize JSON to/from files on a file system.
 *
 * @author Mihai Cadariu
 * @since 03.11.2015
 */
public class JSonSerializer {

    private final static Logger log = LoggerFactory.getLogger(JSonSerializer.class);
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Create new serializer and initializes it with configurable properties
     */
    public JSonSerializer() {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, ToolkitConfiguration.INSTANCE.isPrettyPrintJson());
    }

    /**
     * Serialize the given object to the specified file
     *
     * @param file   File the file to serialize to
     * @param object the payload to serialize
     * @param <T>    type of the payload to serialize
     */
    public <T> void serialize(File file, T object) {
        try {
            log.debug("Serialize {} to JSon file {}", object, file);
            mapper.writeValue(file, object);
        } catch (IOException e) {
            log.error("Error serializing object " + object, e);
        }
    }

    /**
     * Deserialize the given file into an object of the specified type
     *
     * @param file   File the file containing JSON to deserialize
     * @param aClass the class of whose object to create while deserializing
     * @param <T>    type of the payload to deserialize
     * @return an instance of specified class containing the deserialized values
     */
    public <T> T deserialize(File file, Class<T> aClass) {
        try {
            log.debug("Deserialize JSon file {} to {}", file, aClass);
            return mapper.readValue(file, aClass);
        } catch (JsonMappingException e) {
            log.debug("Error reading model file " + file);
        } catch (IOException ioe) {
            log.error("Error deserializing file " + file, ioe);
            throw new SerializationException(ioe);
        }

        return null;
    }
}

package com.mitza.toolkit.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Specialization class of ByteArrayOutputStream that provides additional functionality such as reversing the output stream
 * and converting the stream to UTF-8 encoding.
 *
 * @author Mihai Cadariu
 * @since 07.01.2016
 */
public class ByteArrayStringBuilder extends ByteArrayOutputStream {

    private final Logger log = LoggerFactory.getLogger(ByteArrayStringBuilder.class);

    /**
     * Reverses the current output stream
     */
    public void reverse() {
        for (int i = 0; i < count >> 1; i++) {
            byte aux = buf[i];
            buf[i] = buf[count - i - 1];
            buf[count - i - 1] = aux;
        }
    }

    /**
     * Writes the bytes from the given String parameter to this output stream. The bytes are first converted to UTF-8 encoding.
     *
     * @param partial String to write to this output stream
     */
    public void write(String partial) throws IOException {
        if (partial == null) {
            return;
        }

        write(partial.getBytes("UTF-8"));
    }

    /**
     * Return a UTF-8 representation of this output stream
     *
     * @return String the UTF-8 encoding of this output stream
     */
    @Override
    public String toString() {
        try {
            return super.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("Cannot convert buffer to UTF-8 string", e);
            throw new IndexException(e);
        }
    }
}

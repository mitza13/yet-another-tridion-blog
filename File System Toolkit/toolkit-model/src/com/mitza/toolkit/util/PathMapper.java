package com.mitza.toolkit.util;

import com.mitza.toolkit.configuration.ToolkitConfiguration;
import com.mitza.util.TcmUri;

import java.io.File;

/**
 * Path mapper used by the Toolkit file system implementation that provides the 4-level nested path to any given
 * JSON model file identified by its TcmUri.
 * <p/>
 * This class is also a stand-alone Java application that can be executed to display the path to a given TcmUri argument.
 *
 * @author Mihai Cadariu
 * @since 02.11.2015
 */
public class PathMapper {

    public static final int BUCKET_COUNT = 10000;

    /**
     * Main method of this stand-alone application that calculates the mapped 4-level deep path and outputs it to the
     * System out.
     *
     * @param args String[] with the application arguments. One argument is required in the form of a TcmUri.
     *             Example: tcm:1-23-64
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Use a TcmUri as program argument (e.g. tcm:1-23-64)");
            return;
        }

        try {
            TcmUri tcmUri = new TcmUri(args[0]);
            System.out.println("Model " + tcmUri);

            PathMapper program = new PathMapper();
            System.out.println("Relative path " + File.separator + program.getModelFilePath(tcmUri));
        } catch (Exception e) {
            System.err.println("Error occurred: " + e);
            e.printStackTrace(System.err);
        }
    }

    /**
     * Return the mapped absolute path corresponding to the given TcmUri parameter
     *
     * @param tcmUri Tcmuri the id of the item to map
     * @return String the fully qualified mapped path inluding the JSON Root
     */
    public String getModelAbsolutePath(TcmUri tcmUri) {
        return ToolkitConfiguration.INSTANCE.getJsonRoot() + getModelFilePath(tcmUri);
    }

    /**
     * Return the mapped path corresponding to the given TcmUri parameter relative to the JSON Root
     *
     * @param tcmUri Tcmuri the id of the item to map
     * @return String the mapped path relative to the JSON Root
     */
    public String getModelFilePath(TcmUri tcmUri) {
        String bucket = Integer.toString(getBucketId(tcmUri));
        bucket = "0000".substring(bucket.length()) + bucket;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < bucket.length(); i++) {
            result.append(bucket.charAt(i));
            result.append(File.separator);
        }

        result.append(getModelFilename(tcmUri));

        return result.toString();
    }

    /**
     * Return the model file name corresponding to the given TcmUri parameter
     *
     * @param tcmUri Tcmuri the id of the item to map
     * @return String the model file name (e.g. 1-23.json)
     */
    public String getModelFilename(TcmUri tcmUri) {
        if (tcmUri == null) {
            tcmUri = TcmUri.NULL_URI;
        }

        return String.format("%s.json", tcmUri.toString().substring(4));
    }

    private int getBucketId(TcmUri tcmUri) {
        String uri = tcmUri.toString();
        int messageHashCode = Math.abs(uri.hashCode());
        return messageHashCode % BUCKET_COUNT;
    }
}

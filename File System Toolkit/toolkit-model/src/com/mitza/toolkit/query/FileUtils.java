package com.mitza.toolkit.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Static helper class providing byte level operations for RandomAccessFile and FileChannel objects
 *
 * @author Mihai Cadariu
 * @since 26.11.2015
 */
public class FileUtils {

    private static final int PAGE_SIZE = 1 << 14;
    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    /**
     * Insert the given content into the random access file at a specified position in the file. The file increases in length.
     *
     * @param file    RandomAccessFile to insert into
     * @param offset  int position in the file to start inserting at
     * @param content String the content to insert
     */
    public static void insert(RandomAccessFile file, int offset, String content) throws IOException {
        log.debug("Insert at position {} content '{}'", new Object[]{offset, content});

        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        expand(file, offset, bytes.length);
        file.seek(offset);
        file.write(bytes);
    }

    /**
     * Replace a section of a random access file with the given content. The length of the file increases or shrinks
     * according to the length of the content relative to the two file offset values.
     *
     * @param file        RandomAccessFile to replace a section from
     * @param offsetStart int position in the file to start replace from
     * @param offsetEnd   int position in the file to end replace to
     * @param content     String the content to replace with
     */
    public static void replace(RandomAccessFile file, int offsetStart, int offsetEnd, String content) throws IOException {
        log.debug("Replace content between positions {}-{} with '{}'", new Object[]{offsetStart, offsetEnd, content});

        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        long delta = bytes.length - offsetEnd + offsetStart;

        if (delta > 0) {
            expand(file, offsetStart, delta);
        } else if (delta < 0) {
            shrink(file, offsetStart, -delta);
        }

        file.seek(offsetStart);
        file.write(bytes);
    }

    /**
     * Removes a chunk of the specified size from a random access file starting with a specified position in the file.
     * The file decreases in length. The content after the chunk being removed is moved to the specified offset.
     *
     * @param file   RandomAccessFile to shrink
     * @param offset long position in the file to start shrink at
     * @param size   long the length of the chunk in bytes to remove
     */
    public static void shrink(RandomAccessFile file, long offset, long size) throws IOException {
        log.debug("Shrink at position {} with {} bytes", offset, size);

        long fileLength = file.length();
        offset = Math.min(offset, fileLength);
        long newLength = fileLength - size;

        if (offset >= newLength) {
            setFileLength(file, offset);
            log.debug("Shrinking file ok");
            return;
        }

        int pageSize;
        long start = offset + size;
        byte[] buffer = new byte[PAGE_SIZE];

        do {
            file.seek(start);
            pageSize = file.read(buffer);

            file.seek(start - size);
            file.write(buffer, 0, pageSize);

            start += pageSize;
        } while (start - size < newLength);

        setFileLength(file, newLength);
        log.debug("Shrinking file ok");
    }

    /**
     * Graciously closes RandomAccessFile, FileChannel and releases FileLock
     *
     * @param raf         RandomAccessFile to close
     * @param fileChannel FileChannel to close
     * @param lock        FileLock to release
     * @param name        String name of the lock
     */
    public static void closeResources(RandomAccessFile raf, FileChannel fileChannel, FileLock lock, String name) {
        try {
            if (lock != null) {
                log.debug("Release lock {}", name);
                lock.release();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (raf != null) {
                raf.close();
            }
        } catch (IOException e) {
            log.error("Error closing RandomAccessFile " + name, e);
        }
    }

    /**
     * Return the content of the specified file as a UTF-8 encoded String
     *
     * @param fileName String the file name
     * @return String the UTF-8 encoded file content
     */
    public static String readAllLines(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        byte[] bytes = Files.readAllBytes(path);

        return new String(bytes, StandardCharsets.UTF_8);
    }

    /**
     * Create an exclusive write lock on the entire specified FileChannel
     *
     * @param fileChannel FileChannel to create lock on
     * @param name        String the name of the lock
     * @return FileLock the write lock
     */
    public static FileLock writeLock(FileChannel fileChannel, String name) {
        return lock(fileChannel, name, false);
    }

    private static void setFileLength(RandomAccessFile file, long length) {
        try {
            file.setLength(length);
        } catch (IOException e) {
            log.error("Cannot set file length", e);
        }
    }

    private static void expand(RandomAccessFile file, long offset, long size) throws IOException {
        log.debug("Expand at position {} with {} bytes", offset, size);

        long fileLength = file.length();
        setFileLength(file, Math.max(fileLength, offset) + size);

        long start = Math.max(offset, fileLength - PAGE_SIZE);
        long end = Math.min(start + PAGE_SIZE, fileLength);

        if (end <= start) {
            return;
        }

        boolean loop;
        byte[] buffer = new byte[PAGE_SIZE];

        do {
            int pageSize = (int) (end - start);
            file.seek(start);
            file.read(buffer, 0, pageSize);

            file.seek(start + size);
            file.write(buffer, 0, pageSize);

            loop = start > offset;
            end = start;
            start = Math.max(offset, start - PAGE_SIZE);
        } while (loop);
    }

    private static FileLock lock(FileChannel fileChannel, String name, boolean shared) {
        log.debug("Try acquire {} lock {}", shared ? "read" : "write", name);

        try {
            FileLock result = fileChannel.lock(0L, Long.MAX_VALUE, shared);
            log.debug("Acquired {} lock {}", shared ? "read" : "write", name);
            return result;
        } catch (IOException e) {
            log.error("Cannot lock channel", e);
        }

        return null;
    }
}

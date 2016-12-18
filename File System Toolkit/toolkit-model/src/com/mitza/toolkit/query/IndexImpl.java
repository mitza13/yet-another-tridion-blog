package com.mitza.toolkit.query;

import com.mitza.toolkit.domain.ItemTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * General index class implementing IndexAbstract methods to provide a unified functionality for all index implementations.
 *
 * @author Mihai Cadariu
 * @since 26.11.2015
 */
public class IndexImpl extends IndexAbstract {

    private final File file;
    private final Logger log = LoggerFactory.getLogger(IndexImpl.class);

    /**
     * Create new instance on the specified file
     *
     * @param file File the file handler for this index
     */
    public IndexImpl(File file) {
        log.debug("Create new instance {}", file);
        this.file = file;
    }

    /**
     * Return the indexed values associated with the specified key without applying any filter
     *
     * @param key String the key to use
     * @return Set of String values from index
     */
    @Override
    public Set<String> get(String key) {
        return get(key, FilterImpl.EMPTY_FILTER);
    }

    /**
     * Return the indexed values associated with the specified key and after applying the specified filter
     *
     * @param key    String the key to use
     * @param filter Filter the filter to apply
     * @return
     */
    @Override
    public Set<String> get(String key, Filter filter) {
        log.debug("Get from index key={}, filter={}", key, filter);

        key = normalizeString(key);

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "rw");
            FileChannel fileChannel = raf.getChannel();

            IndexEntry indexEntry = binarySearch(fileChannel, key, filter);
            Set<String> result = indexEntry.getValues();

            log.debug("Return index values {}", result);
            return result;
        } catch (IOException e) {
            log.error("Error occurred", e);
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    log.error("Error closing RandomAccessFile " + file, e);
                }
            }
        }

        return null;
    }

    /**
     * Return the indexed values that fall within a given keys min/max interval,
     * after they were filtered by the given Filter
     *
     * @param startKey String the key specifying the start interval
     * @param endKey   String the key specifying the end interval
     * @param filter   Filter the filter to apply
     * @return
     */
    @Override
    public Set<String> get(String startKey, String endKey, Filter filter) {
        log.debug("Get from index startKey={}, endKey={}, filter={}", new Object[]{startKey, endKey, filter});

        startKey = normalizeString(startKey);
        endKey = normalizeString(endKey);

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "rw");
            FileChannel fileChannel = raf.getChannel();

            Set<String> result = new TreeSet<>();
            List<IndexEntry> indexEntries = rangeSearch(fileChannel, startKey, endKey, filter);
            for (IndexEntry indexEntry : indexEntries) {
                result.addAll(indexEntry.getValues());
            }

            log.debug("Return index values {}", result);
            return result;
        } catch (IOException e) {
            log.error("Error occurred", e);
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    log.error("Error closing RandomAccessFile " + file, e);
                }
            }
        }

        return null;
    }

    /**
     * Add the given value to the index under the given key
     *
     * @param key   String the key to use
     * @param value String the value to use
     * @return
     */
    @Override
    public synchronized boolean put(String key, String value) {
        log.debug("Add to index key={} and value={}", key, value);

        key = normalizeString(key);
        value = normalizeString(value);

        if (key.length() > 100 || value.length() > 100) {
            return false;
        }

        RandomAccessFile raf = null;
        FileChannel fileChannel = null;
        FileLock lock = null;
        try {
            raf = new RandomAccessFile(file, "rw");
            fileChannel = raf.getChannel();
            lock = FileUtils.writeLock(fileChannel, file.getName());

            IndexEntry indexEntry = binarySearch(fileChannel, key);
            long startPosition = indexEntry.getStartPosition();

            if (indexEntry.isEmpty()) {
                indexEntry.addValue(value);
                String content = indexEntry.encodeLine() + (char) ENTRY_SEPARATOR;
                FileUtils.insert(raf, (int) startPosition, content);
                return true;
            } else if (!indexEntry.containsValue(value)) {
                indexEntry.addValue(value);
                String content = indexEntry.encodeLine();
                long endPosition = indexEntry.getEndPosition();
                FileUtils.replace(raf, (int) startPosition, (int) endPosition, content);
                return true;
            }
        } catch (IOException e) {
            log.error("Error occurred", e);
        } finally {
            FileUtils.closeResources(raf, fileChannel, lock, file.getName());
        }

        return false;
    }

    /**
     * Remove the entire entry under the given key from the index
     *
     * @param key String the key to remove
     * @return
     */
    @Override
    public synchronized boolean remove(String key) {
        log.debug("Remove from index key={}", key);

        key = normalizeString(key);
        if (key.length() > 100) {
            return false;
        }

        RandomAccessFile raf = null;
        FileChannel fileChannel = null;
        FileLock lock = null;
        try {
            raf = new RandomAccessFile(file, "rw");
            fileChannel = raf.getChannel();
            lock = FileUtils.writeLock(fileChannel, file.getName());

            IndexEntry indexEntry = binarySearch(fileChannel, key);
            if (!indexEntry.isEmpty()) {
                long startPosition = indexEntry.getStartPosition();
                long size = indexEntry.getEndPosition() - startPosition + 1;
                FileUtils.shrink(raf, startPosition, size);
                return true;
            }
        } catch (IOException e) {
            log.error("Error occurred", e);
        } finally {
            FileUtils.closeResources(raf, fileChannel, lock, file.getName());
        }

        return false;
    }

    /**
     * Remove a given value for a given key from the index. If the index entry is left
     * without any values, the entire index entry should be removed.
     *
     * @param key   String the key to use
     * @param value String the value to remove
     * @return
     */
    @Override
    public synchronized boolean remove(String key, String value) {
        log.debug("Remove from index key={} and value={}", key, value);

        key = normalizeString(key);
        value = normalizeString(value);
        if (key.length() > 100 || value.length() > 100) {
            return false;
        }

        RandomAccessFile raf = null;
        FileChannel fileChannel = null;
        FileLock lock = null;
        try {
            raf = new RandomAccessFile(file, "rw");
            fileChannel = raf.getChannel();
            lock = FileUtils.writeLock(fileChannel, file.getName());

            IndexEntry indexEntry = binarySearch(fileChannel, key);
            if (indexEntry.removeValue(value)) {
                int startPosition = (int) indexEntry.getStartPosition();
                int endPosition = (int) indexEntry.getEndPosition();

                if (indexEntry.isEmpty()) {
                    long size = indexEntry.getEndPosition() - startPosition + 1;
                    FileUtils.shrink(raf, startPosition, size);
                } else {
                    String content = indexEntry.encodeLine();
                    FileUtils.replace(raf, startPosition, endPosition, content);
                }
                return true;
            }
        } catch (IOException e) {
            log.error("Error occurred", e);
        } finally {
            FileUtils.closeResources(raf, fileChannel, lock, file.getName());
        }

        return false;
    }

    private IndexEntry readIndexEntry(MemoryBuffer buffer, String key, long position, Filter filter) throws IOException {
        long duration = System.currentTimeMillis();
        log.debug("Read index entry at position {}", position);

        int capacity = buffer.capacity();
        if (position >= capacity) {
            log.debug("Key '{}' not in index", key);
            return new IndexEntry(key, capacity);
        }

        while (position >= 0) {
            byte b = buffer.get((int) position);
            if (b > 13) {
                break;
            }
            position--;
        }

        String foundKey = key;
        ByteArrayStringBuilder builder = new ByteArrayStringBuilder();
        Set<String> values = new TreeSet<>();
        long start = position;
        boolean foundDelimiter = false;
        String partial = null;

        while (start >= 0) {
            byte b = buffer.get((int) start);
            if (b == ENTRY_SEPARATOR || b == 0) {
                start++;
                break;
            } else if (b == VALUE_SEPARATOR) {
                if (builder.size() > 0) {
                    builder.reverse();
                    if (foundDelimiter) {
                        addValue(values, builder, filter);
                    } else {
                        partial = builder.toString();
                    }
                    builder.reset();
                }
                foundDelimiter = true;
            } else {
                builder.write(b);
            }
            start--;
        }

        builder.reverse();
        start = Math.max(start, 0);

        if (foundDelimiter) {
            foundKey = builder.toString();

            IndexEntry indexEntry = checkFoundKey(buffer, position, start, capacity, key, foundKey, values);
            if (indexEntry != null) {
                return indexEntry;
            }

            builder.reset();
            if (partial != null) {
                builder.write(partial);
            }
        }

        long end = position + 1;

        while (end < capacity) {
            byte b = buffer.get((int) end++);
            if (b == ENTRY_SEPARATOR || b == 0) {
                end--;
                break;
            } else if (b == VALUE_SEPARATOR) {
                if (foundDelimiter) {
                    addValue(values, builder, filter);
                } else {
                    foundDelimiter = true;
                    foundKey = builder.toString();

                    IndexEntry indexEntry = checkFoundKey(buffer, position, start, capacity, key, foundKey, values);
                    if (indexEntry != null) {
                        return indexEntry;
                    }
                }
                builder.reset();
            } else {
                builder.write(b);
            }
        }

        if (foundDelimiter) {
            addValue(values, builder, filter);
        } else {
            foundKey = builder.toString();
        }

        IndexEntry result = new IndexEntry(foundKey, values, start, end);

        duration = System.currentTimeMillis() - duration;
        log.debug("Read index entry {} in {} millis", result, duration);
        return result;
    }

    private void readIndexEntries(MemoryBuffer buffer, long position, String startKey, String endKey, Filter filter, List<IndexEntry> result) throws IOException {
        long duration = System.currentTimeMillis();
        log.debug("Read index entries at position {}", position);

        boolean includeBoundaries = filter.isIncludeRangeBoundaries();
        long start = position - 1;

        while (start >= 0) {
            IndexEntry entry = readIndexEntry(buffer, null, start, filter);
            int compare = compareKey(startKey, entry.getKey());
            if (compare > 0 || !includeBoundaries && compare == 0) {
                break;
            }

            result.add(entry);
            start = entry.getStartPosition() - 1;
        }

        long end = position;
        int capacity = buffer.capacity();

        while (end < capacity) {
            IndexEntry entry = readIndexEntry(buffer, null, end, filter);
            int compare = compareKey(endKey, entry.getKey());
            if (compare < 0 || !includeBoundaries && compare == 0) {
                break;
            }

            result.add(entry);
            end = entry.getEndPosition() + 1;
        }

        duration = System.currentTimeMillis() - duration;
        log.debug("Read index entries {} in {} millis", result, duration);
    }

    private IndexEntry readIndexKey(MemoryBuffer buffer, long position) throws IOException {
        long duration = System.currentTimeMillis();
        log.debug("Read index key at position {}", position);

        int capacity = buffer.capacity();
        if (position >= capacity) {
            return new IndexEntry("", capacity);
        }

        String foundKey = null;
        ByteArrayStringBuilder builder = new ByteArrayStringBuilder();
        long start = position;
        boolean foundDelimiter = false;

        while (start >= 0) {
            byte b = buffer.get((int) start);
            if (b == ENTRY_SEPARATOR || b == 0) {
                start++;
                break;
            } else if (b == VALUE_SEPARATOR) {
                if (builder.size() > 0) {
                    builder.reset();
                }
                foundDelimiter = true;
            } else {
                builder.write(b);
            }
            start--;
        }

        builder.reverse();
        start = Math.max(start, 0);

        if (foundDelimiter) {
            foundKey = builder.toString();
            builder.reset();
        }

        long end = position + 1;

        while (end < capacity) {
            byte b = buffer.get((int) end++);
            if (b == ENTRY_SEPARATOR || b == 0) {
                end--;
                break;
            } else if (!foundDelimiter) {
                if (b == VALUE_SEPARATOR) {
                    foundKey = builder.toString();
                    builder.reset();
                    foundDelimiter = true;
                } else {
                    builder.write(b);
                }
            }
        }

        IndexEntry indexEntry = new IndexEntry(foundKey, null, start, end);

        duration = System.currentTimeMillis() - duration;
        log.debug("Read index key {} in {} millis", indexEntry, duration);
        return indexEntry;
    }

    private long findEndOfEntry(MemoryBuffer buffer, long position, int capacity) {
        while (position < capacity) {
            byte b = buffer.get((int) position++);
            if (b == ENTRY_SEPARATOR || b == 0) {
                position--;
                break;
            }
        }

        return position;
    }

    private boolean addValue(Set<String> values, ByteArrayStringBuilder builder, Filter filter) {
        String value = builder.toString();
        ItemTypes checkItemType = filter.getItemType();

        if (checkItemType != null) {
            switch (checkItemType) {
                case COMPONENT:
                    if (value.endsWith("-64")) {
                        return false;
                    }
                    break;

                case PAGE:
                    if (!value.endsWith("-64")) {
                        return false;
                    }
                    break;
            }
        }

        Set<Integer> publicationIds = filter.getPublicationIds();
        return publicationIds.isEmpty() ? values.add(value) : startsWithAny(value, publicationIds) && values.add(value);
    }

    private boolean startsWithAny(String value, Set<Integer> publicationIds) {
        for (Integer publicationId : publicationIds) {
            if (value.startsWith(String.format("%d-", publicationId))) {
                return true;
            }
        }

        return false;
    }

    private IndexEntry binarySearch(FileChannel fileChannel, String key) throws IOException {
        log.debug("Binary search key={}", key);

        MemoryBuffer buffer = null;
        try {
            buffer = MemoryBufferFactory.INSTANCE.getBuffer(fileChannel, FileChannel.MapMode.READ_ONLY);
            return binarySearch(buffer, key, FilterImpl.EMPTY_FILTER, 0, buffer.capacity());
        } finally {
            if (buffer != null) {
                buffer.close();
            }
        }
    }

    private IndexEntry binarySearch(FileChannel fileChannel, String key, Filter filter) throws IOException {
        log.debug("Binary search key={}, {}", key, filter);

        MemoryBuffer buffer = null;
        try {
            buffer = MemoryBufferFactory.INSTANCE.getBuffer(fileChannel, FileChannel.MapMode.READ_ONLY);
            return binarySearch(buffer, key, filter, 0, buffer.capacity());
        } finally {
            if (buffer != null) {
                buffer.close();
            }
        }
    }

    private IndexEntry binarySearch(MemoryBuffer buffer, String key, Filter filter, long low, long high) throws IOException {
        log.debug("Binary search key={}, {}, low {}, high {}", new Object[]{key, filter, low, high});

        if (low > high) {
            log.debug("Key '{}' not in index", key);
            return new IndexEntry(key, low);
        }

        long middle = (low + high) >>> 1;
        IndexEntry indexEntry = readIndexEntry(buffer, key, middle, filter);
        if (indexEntry.isEmpty()) {
            return indexEntry;
        }

        int compare = compareKey(key, indexEntry.getKey());
        if (compare == 0) {
            log.debug("Found in index {}", indexEntry);
            return indexEntry;
        } else if (compare > 0) {
            return binarySearch(buffer, key, filter, indexEntry.getEndPosition() + 1, high);
        } else {
            return binarySearch(buffer, key, filter, low, indexEntry.getStartPosition() - 1);
        }
    }

    private List<IndexEntry> rangeSearch(FileChannel fileChannel, String startKey, String endKey, Filter filter) throws IOException {
        log.debug("Range search startKey={}, endKey={}, {}", new Object[]{startKey, endKey, filter});

        MemoryBuffer buffer = null;
        try {
            List<IndexEntry> result = new ArrayList<>();
            buffer = MemoryBufferFactory.INSTANCE.getBuffer(fileChannel, FileChannel.MapMode.READ_ONLY);
            rangeSearch(buffer, startKey, endKey, filter, 0, buffer.capacity(), result);
            return result;
        } finally {
            if (buffer != null) {
                buffer.close();
            }
        }
    }

    private void rangeSearch(MemoryBuffer buffer, String startKey, String endKey, Filter filter, long low, long high, List<IndexEntry> result) throws IOException {
        log.debug("Range search startKey={}, endKey={}, {}, low {}, high {}", new Object[]{startKey, endKey, filter, low, high});

        if (low > high || low >= buffer.capacity()) {
            return;
        }

        long middle = (low + high) >>> 1;
        IndexEntry indexEntry = readIndexKey(buffer, middle);

        int compareStart = compareKey(startKey, indexEntry.getKey());
        boolean includeBoundaries = filter.isIncludeRangeBoundaries();
        if (compareStart > 0 || !includeBoundaries && compareStart == 0) {
            rangeSearch(buffer, startKey, endKey, filter, indexEntry.getEndPosition() + 1, high, result);
        } else {
            int compareEnd = compareKey(endKey, indexEntry.getKey());
            if (compareEnd < 0 || !includeBoundaries && compareEnd == 0) {
                rangeSearch(buffer, startKey, endKey, filter, low, indexEntry.getStartPosition() - 1, result);
            } else {
                log.debug("Found in range {}", indexEntry);
                readIndexEntries(buffer, indexEntry.getStartPosition(), startKey, endKey, filter, result);
            }
        }
    }

    private int compareKey(String key1, String key2) {
        if (key1 == null && key2 == null) {
            return 0;
        } else if (key1 == null) {
            return -1;
        } else if (key2 == null) {
            return 1;
        }

        String[] split1 = splitKey(key1);
        String[] split2 = splitKey(key2);

        int compare = split1[0].compareTo(split2[0]);
        if (compare == 0) {
            String s1 = split1.length == 2 ? split1[1] : "";
            String s2 = split2.length == 2 ? split2[1] : "";

            try {
                long k12 = Long.parseLong(s1);
                long k22 = Long.parseLong(s2);
                compare = k12 == k22 ? 0 : k12 > k22 ? 1 : -1;
            } catch (NumberFormatException nfe) {
                try {
                    float k12 = Float.parseFloat(s1);
                    float k22 = Float.parseFloat(s2);
                    compare = k12 == k22 ? 0 : k12 > k22 ? 1 : -1;
                } catch (NumberFormatException nfe2) {
                    compare = s1.compareTo(s2);
                }
            }
        }

        return compare;
    }

    private String[] splitKey(String key) {
        if (key == null) {
            return new String[0];
        }

        int idx = key.indexOf(KEY_SEPARATOR);
        if (idx < 0) {
            return new String[]{key};
        } else {
            return new String[]{key.substring(0, idx), key.substring(idx + 1)};
        }
    }

    private IndexEntry checkFoundKey(MemoryBuffer buffer, long position, long start, int capacity, String key, String foundKey, Set<String> values) {
        if (key != null) {
            int compareTo = compareKey(key, foundKey);
            if (compareTo < 0) {
                values.add("");
                IndexEntry indexEntry = new IndexEntry(foundKey, values, start, -1);
                log.debug("Read partial {}", indexEntry);
                return indexEntry;
            } else if (compareTo > 0) {
                values.add("");
                IndexEntry indexEntry = new IndexEntry(foundKey, values, start, findEndOfEntry(buffer, position + 1, capacity));
                log.debug("Read partial {}", indexEntry);
                return indexEntry;
            }
        }
        return null;
    }
}

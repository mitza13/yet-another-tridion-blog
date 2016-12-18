package com.mitza.toolkit.test.model;

import com.mitza.toolkit.query.FileUtils;
import com.mitza.toolkit.query.Filter;
import com.mitza.toolkit.query.FilterImpl;
import com.mitza.toolkit.query.IndexAbstract;
import com.mitza.toolkit.query.IndexFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Set;

/**
 * @author Mihai Cadariu
 * @since 26.11.2015
 */
public class IndexTest {

    private static final String FILENAME = "/Users/mihai/Projects/yet-another-tridion-blog/File System Toolkit/files/jsonRoot/custom-string.index";
    //    private static final String FILENAME = "c:\\temp\\schema.index";
    private final Logger log = LoggerFactory.getLogger(IndexTest.class);
//    private RandomAccessFile file;

    public IndexTest() {
        long duration = System.currentTimeMillis();
        log.info("Start IndexTest");

//        try {
//            log.debug("Using file {}", FILENAME);

//            file = new RandomAccessFile(FILENAME, "rw");
//            log.debug("Initial file content ({} bytes):\n{}", file.length(), FileUtils.readAllLines(FILENAME));

//            runConcurrentTest();
//            runShrinkTest();
//            runBigTest();
//            runRangeTest();
//            runRemoveTest();
        runSchemaIndexText();
//        } catch (IOException e) {
//            log.error("IOException occurred", e);
//        } finally {
//            if (file != null) {
//                try {
//                    file.close();
//                } catch (IOException e) {
//                    log.error("Error while closing RandomAccessFile " + file, e);
//                }
//            }
//            new File(FILENAME).delete();
//            log.debug("Deleted file {}", FILENAME);
//        }

        duration = System.currentTimeMillis() - duration;
        log.debug("<<< IndexTest took {} millis", duration);
    }

    public void runShrinkTest() throws IOException {
        IndexAbstract index = IndexFactory.INSTANCE.getCustomMetaStringIndex();
        String key;
        String value;

        log.info("Start runShrinkTest");

        key = "page_subtitle|Set a financial goal and you’ve taken the first step toward reaching it.";
        value = "222-20514-64";
        index.put(key, value);
        log.info("Inserted {}={}\n{}", new Object[]{key, value, FileUtils.readAllLines(FILENAME)});

        key = "aaaaaaaaaaaaaaaa";
        value = "111111111";
        index.put(key, value);
        log.info("Inserted {}={}\n{}", new Object[]{key, value, FileUtils.readAllLines(FILENAME)});

        value = "222222";
        index.put(key, value);
        log.info("Inserted {}={}\n{}", new Object[]{key, value, FileUtils.readAllLines(FILENAME)});

        key = "bbbbbbbbbbbbbbbb";
        value = "33333333";
        index.put(key, value);
        log.info("Inserted {}={}\n{}", new Object[]{key, value, FileUtils.readAllLines(FILENAME)});

        key = "ccccccccc";
        value = "444444";
        index.put(key, value);
        log.info("Inserted {}={}\n{}", new Object[]{key, value, FileUtils.readAllLines(FILENAME)});

        value = "555";
        index.put(key, value);
        log.info("Inserted {}={}\n{}", new Object[]{key, value, FileUtils.readAllLines(FILENAME)});

        value = "444444";
        index.remove(key, value);
        log.info("Removed {}={}\n{}", new Object[]{key, value, FileUtils.readAllLines(FILENAME)});

        key = "bbbbbbbbbbbbbbbb";
        value = "33333333";
        index.remove(key, value);
        log.info("Removed {}={}\n{}", new Object[]{key, value, FileUtils.readAllLines(FILENAME)});

//        FileUtils.shrink(file, 6, 3);
//        log.debug("File content after shrink ({} bytes):\n{}", file.length(), FileUtils.readAllLines(FILENAME));
    }

    private void runConcurrentTest() {
        log.info("Run Concurrent Test");

        new Thread(new ConcurrentTest(), "aaa").start();
        new Thread(new ConcurrentTest(), "bbb").start();
        new Thread(new ConcurrentTest(), "ccc").start();
        new Thread(new ConcurrentTest(), "ddd").start();

        log.info("Done Concurrent Test");
    }

    private void runSchemaIndexText() {
        long duration = System.currentTimeMillis();

        IndexAbstract index = IndexFactory.INSTANCE.getSchemaIndex();

        String key = "a";
        String value = "v1234567890";

        Set<String> values = index.get(key);
        log.debug("Index get('{}')={}", key, values);

        boolean putResult = index.put(key, value);
        log.debug("Index put('{}', '{}')={}", new Object[]{key, value, putResult});

        values = index.get(key);
        log.debug("Index get('{}')={}", key, values);

        value = "v2";
        putResult = index.put(key, value);
        log.debug("Index put('{}', '{}')={}", new Object[]{key, value, putResult});

        key = "ccc";
        value = "v1";
        putResult = index.put(key, value);
        log.debug("Index put('{}', '{}')={}", new Object[]{key, value, putResult});

        key = "bbb";
        putResult = index.put(key, value);
        log.debug("Index put('{}', '{}')={}", new Object[]{key, value, putResult});

        duration = System.currentTimeMillis() - duration;
        log.debug("SchemaIndexText took {} millis", duration);
    }

    private void runBigTest() throws IOException {
        IndexAbstract index = IndexFactory.INSTANCE.getSchemaIndex();

        boolean putResult = index.put("aaa", "aaaValue");
        log.debug("Put result: " + putResult);

        putResult = index.put("ccc", "cccValue");
        log.debug("Put result: " + putResult);

        putResult = index.put("ccc", "cccValue");
        log.debug("Put result: " + putResult);

        putResult = index.put("xxx", "xxxValue");
        log.debug("Put result: " + putResult);

        putResult = index.put("rrr", "rrrValue");
        log.debug("Put result: " + putResult);

        putResult = index.put("qqq", "qqqValue");
        log.debug("Put result: " + putResult);

        putResult = index.put("jjj", "jjjValue");
        log.debug("Put result: " + putResult);

        putResult = index.put("zzz", "zzzValue1");
        log.debug("Put result: " + putResult);

//        String filler = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
//        index.put("zzz", filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler +
//                filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler + filler);
//        log.debug("Put result: " + putResult);

        putResult = index.put("zzz", "zzzValue2");
        log.debug("Put result: " + putResult);

        putResult = index.put("z", "Bala");
        log.debug("Put result: " + putResult);

        putResult = index.put("zzzz", "Ala");
        log.debug("Put result: " + putResult);

//        log.debug("File content after insert ({} bytes):\n{}", file.length(), FileUtils.readAllLines(FILENAME));

        long duration = System.currentTimeMillis();

        Set<String> values = index.get("aaa");
        log.debug("Found {}", values);

        values = index.get("xxx");
        log.debug("Found {}", values);

        values = index.get("ccc");
        log.debug("Found {}", values);

        values = index.get("rrr");
        log.debug("Found {}", values);

        values = index.get("aaa");
        log.debug("Found {}", values);

        values = index.get("qqq");
        log.debug("Found {}", values);

        values = index.get("jjj");
        log.debug("Found {}", values);

        values = index.get("zzz");
        log.debug("Found {}", values);

        duration = System.currentTimeMillis() - duration;
        log.debug("<<< BinarySearch duration {} millis", duration);
    }

    public void runRemoveTest() throws IOException {
        IndexAbstract index = IndexFactory.INSTANCE.getSchemaIndex();

        String key = "asdfg";
        String value = "12345";
        String value2 = "67890";
        boolean result = index.put(key, value);
        log.debug("Index put('{}', '{}')={}", new Object[]{key, value, result});

        result = index.put(key, value2);
        log.debug("Index put('{}', '{}')={}", new Object[]{key, value, result});

        Set<String> values = index.get(key);
        log.debug("Index get('{}')={}", key, values);

        result = index.remove(key, value2);
        log.debug("Index remove('{}', '{}')={}", new Object[]{key, value, result});

        values = index.get(key);
        log.debug("Index get('{}')={}", key, values);

        result = index.put(key, value2);
        log.debug("Index put('{}', '{}')={}", new Object[]{key, value, result});

        values = index.get(key);
        log.debug("Index get('{}')={}", key, values);

        result = index.remove(key);
        log.debug("Index remove('{}')={}", key, result);

        values = index.get(key);
        log.debug("Index get('{}')={}", key, values);
    }

    public void runRangeTest() throws IOException {
        IndexAbstract index = IndexFactory.INSTANCE.getCustomMetaDateIndex();

        String startKey = "Date|627802636000";
        String endKey = "Date|1448870994000";
        Filter filter = new FilterImpl(true);

        Set<String> values = index.get(startKey, endKey, filter);
        log.debug("Index get('{}, {}')={}", new Object[]{startKey, endKey, values});
    }
}

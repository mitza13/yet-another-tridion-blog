package com.mitza.toolkit.test.model;

import com.mitza.toolkit.query.IndexAbstract;
import com.mitza.toolkit.query.IndexFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mihai Cadariu
 * @since 07.01.2016
 */
public class ConcurrentTest implements Runnable {

    private final Logger log = LoggerFactory.getLogger(ConcurrentTest.class);
    private final int start = 1000;
    private final int end = 3000;

    @Override
    public void run() {
        IndexAbstract index = IndexFactory.INSTANCE.getCustomMetaStringIndex();

        for (int x = 1; x <= 10; x++) {
            for (int i = start; i <= end; i++) {
                String key = Thread.currentThread().getName();
                for (int j = 0; j <= 4 * Math.random(); j++) {
                    key += "-" + i;
                }

                String value = "value";
                for (int j = 0; j <= 4 * Math.random(); j++) {
                    value += "-" + i;
                }

//                if (Math.random() > 0.5) {
                log.debug("Insert {}: {}", key, value);
                index.put(key, value);
//                } else {
//                    log.debug("Remove {}: {}", key, value);
//                    index.remove(key, value);
//                }

//                try {
//                    Thread.sleep(5);
//                } catch (InterruptedException e) {
//                    log.error("Interrupted", e);
//                }

                if (i % 50 == 0) {
                    log.info("Iteration " + Thread.currentThread().getName() + " " + x + " " + i);
                }
            }
        }
    }
}

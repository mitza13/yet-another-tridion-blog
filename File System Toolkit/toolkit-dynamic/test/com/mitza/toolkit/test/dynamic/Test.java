package com.mitza.toolkit.test.dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mihai Cadariu
 * @since 14.11.2015
 */
public class Test {

    private static final Logger log = LoggerFactory.getLogger(Test.class);
    private static final long minimumTestDuration = 60 * 1000; // in milliseconds

    public static void main(String[] args) {
//        functionalTests();

        loadTests();
    }

    public static void functionalTests() {
        long totalDuration = System.currentTimeMillis();
        log.info("Start functional tests");

        new ComponentPresentationAssemblerTest();
        new ComponentPresentationFactoryTest();
        new DynamicQueryTest();
        new LinkTest();
        new TagTest();
        new ModelTest();

        totalDuration = System.currentTimeMillis() - totalDuration;
        log.info("<<< Total functional tests took {} seconds", totalDuration / 1000.0);
    }

    public static void loadTests() {
        log.info("Start load tests");

        long start = System.currentTimeMillis();
        int iterations = 1000;
        long testDuration = 0;

        while (testDuration < minimumTestDuration) {
            log.info("===== Elapsed {} seconds | execute {} iterations",
                    String.format("%.2f", (System.currentTimeMillis() - start) / 1000.0),
                    iterations);
            testDuration = cpAssemblerLoadTests(iterations);
            iterations *= 2;
        }

        log.info("=====================================================================");
        iterations = 1000;
        testDuration = 0;

        while (testDuration < minimumTestDuration) {
            log.info("===== Elapsed {} seconds | execute {} iterations",
                    String.format("%.2f", (System.currentTimeMillis() - start) / 1000.0),
                    iterations);
            testDuration = cpFactoryLoadTests(iterations);
            iterations *= 2;
        }

        log.info("=====================================================================");
        iterations = 1000;
        testDuration = 0;

        while (testDuration < minimumTestDuration) {
            log.info("===== Elapsed {} seconds | execute {} iterations",
                    String.format("%.2f", (System.currentTimeMillis() - start) / 1000.0),
                    iterations);
            testDuration = dynamicQueryLoadTests(iterations);
            iterations *= 2;
        }

        log.info("=====================================================================");
        iterations = 1000;
        testDuration = 0;

        while (testDuration < minimumTestDuration) {
            log.info("===== Elapsed {} seconds | execute {} iterations",
                    String.format("%.2f", (System.currentTimeMillis() - start) / 1000.0),
                    iterations);
            testDuration = linkLoadTests(iterations);
            iterations *= 2;
        }

        log.info("=====================================================================");
        iterations = 1000;
        testDuration = 0;

        while (testDuration < minimumTestDuration) {
            log.info("===== Elapsed {} seconds | execute {} iterations",
                    String.format("%.2f", (System.currentTimeMillis() - start) / 1000.0),
                    iterations);
            testDuration = modelLoadTest(iterations);
            iterations *= 2;
        }

        start = System.currentTimeMillis() - start;
        log.info("<<< Total load tests took {} seconds", start / 1000.0);
    }

    public static long modelLoadTest(int iterations) {
        ModelTest modelTest = new ModelTest();

        long totalDuration = System.currentTimeMillis();
        long iterationDuration = System.currentTimeMillis();
        log.info("Start ModelFactory load tests");

        int heartbeat = iterations / 10;
        int i = 0;

        while (i++ < iterations) {
            modelTest.runTest();

            if (i % heartbeat == 0 && System.currentTimeMillis() - iterationDuration > 5000) {
                iterationDuration = System.currentTimeMillis() - iterationDuration;
                log.info("{}%: {} iterations took {} millis", new Object[]{
                        String.format("%.0f",  (double)i / iterations * 100),
                        heartbeat,
                        iterationDuration});
                iterationDuration = System.currentTimeMillis();
                logProgress(totalDuration, i, 67); // 67 models contructed per iteration
            }
        }

        logProgress(totalDuration, iterations, 67); // 67 models contructed per iteration
        return System.currentTimeMillis() - totalDuration;
    }

    public static long cpAssemblerLoadTests(int iterations) {
        ComponentPresentationAssemblerTest test = new ComponentPresentationAssemblerTest();

        long start = System.currentTimeMillis();
        long iterationDuration = System.currentTimeMillis();
        log.info("Start Component Presentation Assembler load tests");

        int i = 0;
        int heartbeat = iterations / 10;

        while (i++ < iterations) {
            test.runTest();

            if (i % heartbeat == 0 && System.currentTimeMillis() - iterationDuration > 5000) {
                iterationDuration = System.currentTimeMillis() - iterationDuration;
                log.info("{}%: {} iterations took {} millis", new Object[]{
                        String.format("%.0f",  (double)i / iterations * 100),
                        heartbeat,
                        iterationDuration});
                iterationDuration = System.currentTimeMillis();
                logProgress(start, i, 1); // 1 assemble per iteration
            }
        }

        logProgress(start, iterations, 1);
        return System.currentTimeMillis() - start;
    }

    public static long cpFactoryLoadTests(int iterations) {
        ComponentPresentationFactoryTest test = new ComponentPresentationFactoryTest();

        long start = System.currentTimeMillis();
        long iterationDuration = System.currentTimeMillis();
        log.info("Start Component Presentation Factory load tests");

        int i = 0;
        int heartbeat = iterations / 10;

        while (i++ < iterations) {
            test.loadTest();

            if (i % heartbeat == 0 && System.currentTimeMillis() - iterationDuration > 5000) {
                iterationDuration = System.currentTimeMillis() - iterationDuration;
                log.info("{}%: {} iterations took {} millis", new Object[]{
                        String.format("%.0f",  (double)i / iterations * 100),
                        heartbeat,
                        iterationDuration});
                iterationDuration = System.currentTimeMillis();
                logProgress(start, i, 2); // 2 calls per iteration
            }
        }

        logProgress(start, iterations, 2);
        return System.currentTimeMillis() - start;
    }

    public static long dynamicQueryLoadTests(int iterations) {
        DynamicQueryTest test = new DynamicQueryTest();

        long start = System.currentTimeMillis();
        long iterationDuration = System.currentTimeMillis();
        log.info("Start Dynamic Query load tests");

        int i = 0;
        int heartbeat = iterations / 10;

        while (i++ < iterations) {
            test.loadTest();

            if (i % heartbeat == 0 && System.currentTimeMillis() - iterationDuration > 5000) {
                iterationDuration = System.currentTimeMillis() - iterationDuration;
                log.info("{}%: {} iterations took {} millis", new Object[]{
                        String.format("%.0f",  (double)i / iterations * 100),
                        heartbeat,
                        iterationDuration});
                iterationDuration = System.currentTimeMillis();
                logProgress(start, i, 6); // 6 queries per iteration
            }
        }

        logProgress(start, iterations, 6); // 6 queries per iteration
        return System.currentTimeMillis() - start;
    }

    public static long linkLoadTests(int iterations) {
        long start = System.currentTimeMillis();
        long iterationDuration = System.currentTimeMillis();
        log.info("Start link load tests");

        int i = 0;
        int heartbeat = iterations / 10;

        while (i++ < iterations) {
            new LinkTest();

            if (i % heartbeat == 0 && System.currentTimeMillis() - iterationDuration > 5000) {
                iterationDuration = System.currentTimeMillis() - iterationDuration;
                log.info("{}%: {} iterations took {} millis", new Object[]{
                        String.format("%.0f",  (double)i / iterations * 100),
                        heartbeat,
                        iterationDuration});
                iterationDuration = System.currentTimeMillis();
                logProgress(start, i, 5);
            }
        }

        logProgress(start, iterations, 5);
        return System.currentTimeMillis() - start;
    }

    public static void logProgress(long start, double count, int multiplier) {
        long duration = System.currentTimeMillis() - start;
        double iterationsPerSecond = count / duration * 1000.0;
        double callsPerSecond = iterationsPerSecond * multiplier;

        log.info("Duration {} seconds | {} iterations / second | {} items / second",
                new Object[]{
                        String.format("%.2f", duration / 1000.0),
                        String.format("%.2f", iterationsPerSecond),
                        String.format("%.2f", callsPerSecond)
                });
    }
}

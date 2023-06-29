package dev.glory.concurrent.basic.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class DelayedCallable implements Callable<String> {

    private String         name;
    private long           period;
    private CountDownLatch latch;

    public DelayedCallable(String name, long period, CountDownLatch latch) {
        this.name = name;
        this.period = period;
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {

        try {
            Thread.sleep(period);
            if (latch != null) {
                latch.countDown();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        return name;
    }
}

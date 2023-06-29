package dev.glory.concurrent.basic.executorservice;

public class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("thread name : " + Thread.currentThread().getName() + " is running...");
    }
}

package dev.glory.concurrent.basic.executorservice;

import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorServiceDemo {


    public void execute() {
        ExecutorService executor = Executors.newFixedThreadPool(8);

        executor.submit(new Task());

        IntStream.range(1, 20).forEach(i ->
                executor.execute(() -> {
                    // task to execute
                    System.out.println(MessageFormat.format("thread name : {0} is running... {1}",
                            Thread.currentThread().getName(), i));
                })
        );

        executor.shutdown();
    }


    public static void main(String[] args) {
        ExecutorServiceDemo demo = new ExecutorServiceDemo();
        demo.execute();
    }
}

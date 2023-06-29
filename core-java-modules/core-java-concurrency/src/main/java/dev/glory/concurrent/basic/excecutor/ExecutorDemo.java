package dev.glory.concurrent.basic.excecutor;

import java.util.concurrent.Executor;

public class ExecutorDemo {

    public void execute() {
        Executor executor = new Invoker();
        executor.execute(() -> {

            // task to execute
            System.out.println("Hello World");

        });
    }

    public static void main(String[] args) {
        ExecutorDemo demo = new ExecutorDemo();
        demo.execute();
    }
}

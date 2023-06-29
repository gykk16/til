package dev.glory.concurrent.basic.excecutor;

import java.util.concurrent.Executor;

public class Invoker implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}

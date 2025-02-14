package org.example.multithreading;

import java.util.concurrent.Callable;

public class ImplementsCallable implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println("Current Thread Name: "+Thread.currentThread().getName());
        return "Thread created by implementing Callable Interface ";
    }
}

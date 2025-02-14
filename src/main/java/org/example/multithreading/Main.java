package org.example.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Main Thread Started");
        ImplementsRunnable obj = new ImplementsRunnable();
        Thread t1 = new Thread(obj);
        ExtendingThreadClass t2 = new ExtendingThreadClass();
        ImplementsCallable t3 = new ImplementsCallable();
        ExecutorService es = Executors.newFixedThreadPool(2);

        Thread t4 = new Thread(() -> System.out.println("In new Thread"));

        //t1.setDaemon(true);
        t1.start();

        //t2.setDaemon(true);
        t2.start();
//        Future res = es.submit(t3);
//        System.out.println(res.get());
//        es.close();
        System.out.println("Main Thread Ended");

    }
}

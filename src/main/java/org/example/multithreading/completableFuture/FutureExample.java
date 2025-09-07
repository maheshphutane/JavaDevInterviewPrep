package org.example.multithreading.completableFuture;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        long startTime = System.currentTimeMillis();
        Future<String> userFuture = executor.submit(() -> {
            Thread.sleep(5000); // simulate API call
            return "User: Mahesh";
        });

        Future<String> ordersFuture = executor.submit(() -> {
            Thread.sleep(5000); // simulate API call
            return "Orders: [Pizza, Coffee]";
        });

        // Blocking

        String user = userFuture.get();
        String orders = ordersFuture.get();
        System.out.println(user + " | " + orders+" Time Taken :" + (System.currentTimeMillis()-startTime)+ " MillSec");

        executor.shutdown();



    }
}
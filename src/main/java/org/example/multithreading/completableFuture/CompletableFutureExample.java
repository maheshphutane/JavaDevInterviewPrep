package org.example.multithreading.completableFuture;

import java.util.concurrent.CompletableFuture;


public class CompletableFutureExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(5000); } catch (Exception e) {}
            return "User: Mahesh";
        });

        CompletableFuture<String> ordersFuture = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(5000); } catch (Exception e) {}
            return "Orders: [Pizza, Coffee]";
        });

        // Combine results without blocking
        CompletableFuture<String> combined = userFuture.thenCombine(ordersFuture,
                (user, orders) -> user + " | " + orders);

        combined.thenAccept(x->System.out.println(x+" Time Taken :"+(System.currentTimeMillis()-startTime) + " MillSec"));

        System.out.println("Main thread doing other work completes...");

        // keep main alive until tasks complete
        combined.join();

    }
}

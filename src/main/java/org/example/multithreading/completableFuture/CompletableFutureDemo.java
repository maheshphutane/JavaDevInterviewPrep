package org.example.multithreading.completableFuture;

import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Running Main Methode");
        CompletableFuture<String> helloFuture
                = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "hello";
        });
        CompletableFuture<String> greetingFuture
                = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<String> combinedFuture
                = helloFuture.thenCombine(
                greetingFuture, (m1, m2) -> m1 + " " + m2);

        helloFuture.thenAccept(System.out::println);
        System.out.println(combinedFuture.get());

        System.out.println("Main Methode Completed");
    }
}

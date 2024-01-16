package org.example.multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsMethode {

   public static void main(String[] args) {
        // Create a thread pool with a fixed number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Submit tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            int taskId = i;
            executorService.submit(() -> performTask(taskId));
        }

        // Shutdown the thread pool
        executorService.shutdown();
    }
    private static void performTask(int taskId) {
        System.out.println("Task " + taskId + " started by Thread: " + Thread.currentThread().getName());

        // Simulate some work
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task " + taskId + " completed by Thread: " + Thread.currentThread().getName());
    }
}


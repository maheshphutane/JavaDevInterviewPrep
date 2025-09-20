package org.example.multithreading.print1to100;

import java.util.concurrent.Semaphore;

public class EvenOddSemaphores {
    private static final int MAX = 100;
    private static int count = 1;
    private static final Semaphore oddSem = new Semaphore(1);
    private static final Semaphore evenSem = new Semaphore(0);

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            while (count <= MAX) {
                try {
                    oddSem.acquire();
                    if (count <= MAX && count % 2 != 0) {
                        System.out.println("Odd: " + count++);
                    }
                    evenSem.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (count <= MAX) {
                try {
                    evenSem.acquire();
                    if (count <= MAX && count % 2 == 0) {
                        System.out.println("Even: " + count++);
                    }
                    oddSem.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}

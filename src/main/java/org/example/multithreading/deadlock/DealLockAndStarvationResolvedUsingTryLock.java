package org.example.multithreading.deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DealLockAndStarvationResolvedUsingTryLock {
    static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            boolean acquired = false;
            try {
                acquired = lock.tryLock(1, TimeUnit.SECONDS);
                if (acquired) {
                    Thread.sleep(2000);
                    System.out.println("Thread 1 acquired lock");
                } else {
                    System.out.println("Thread 1 could not acquire lock");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                if (acquired) {
                    lock.unlock();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            boolean acquired = false;
            try {
                acquired = lock.tryLock(1, TimeUnit.SECONDS);
                if (acquired) {
                    Thread.sleep(1000);
                    System.out.println("Thread 2 acquired lock");
                } else {
                    System.out.println("Thread 2 could not acquire lock");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                if (acquired) {
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
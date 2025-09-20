package org.example.multithreading.deadlock;

import java.util.concurrent.TimeUnit;

public class DeadLockScenario {
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(1,TimeUnit.SECONDS.ordinal());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2){
                    System.out.println("Thread 1 acquired lock");
                }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (lock2){
                try {
                    Thread.sleep(1, TimeUnit.SECONDS.ordinal());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1){

                    System.out.println("Thread 2 acquired lock");
                }
            }
        });

        t1.start();
        t2.start();

    }
}

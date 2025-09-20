package org.example.multithreading.deadlock;

public class DeadLockResolvedUsingOrdering {
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2){
                    System.out.println("Thread 1 acquired lock");
                }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2){

                    System.out.println("Thread 2 acquired lock");
                }
            }
        });

        t1.start();
        t2.start();

    }
}

package org.example.multithreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        implementsRunnable t1 = new implementsRunnable();
        Thread t2 = new Thread(t1);
        extendingThreadClass t3 = new extendingThreadClass();
       // t1.run();
        t2.start();
       // System.out.println(t1.getName());
        t2.run();
        System.out.println(t2.getName());
        t3.start();

        System.out.println(t3.getName());
        String test = "hihheyello";

    }
}

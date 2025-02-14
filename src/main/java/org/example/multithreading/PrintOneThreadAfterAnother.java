package org.example.multithreading;

public class PrintOneThreadAfterAnother {
    public static void main(String[] args) {
        // Create the threads
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In Thread T1");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In Thread T2");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        });
        Runnable task = ()->{
            System.out.println("In Thread T3");
        };
        Thread t3 = new Thread(task);
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

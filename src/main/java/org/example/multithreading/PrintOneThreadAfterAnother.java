package org.example.multithreading;

public class PrintOneThreadAfterAnother {
    public static void main(String[] args) {
        // Create the threads
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In Thread T1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In Thread T2");
            }
        });
        Runnable task = ()->{
            System.out.println("In Thread T3");
        };
        Thread t3 = new Thread(task);

        // Start the threads
                t1.start();
                t2.start();
                t3.start();

        // Wait for T1 to complete
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        // Wait for T2 to complete
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        // T3 will automatically run after T2 completes
    }
}

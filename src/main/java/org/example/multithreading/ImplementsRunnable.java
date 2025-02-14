package org.example.multithreading;
//implementing runnable interface
public class ImplementsRunnable implements Runnable{

    /**
     * Runs this operation.
     */
    @Override
    public void run() {

        try {
            Thread.sleep(90000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Tread created by implementing runnable interface");
        System.out.println("Current Thread Name: "+Thread.currentThread().getName());
    }
}

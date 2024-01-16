package org.example.multithreading;
//implementing runnable interface
public class implementsRunnable implements Runnable{

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("Tread from runnable interface");
    }
}

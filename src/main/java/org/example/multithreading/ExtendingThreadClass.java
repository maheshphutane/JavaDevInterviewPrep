package org.example.multithreading;

public class ExtendingThreadClass extends Thread{
    public void run(){
        System.out.println("Thread created by extending Thread Class ");
        System.out.println("Current Thread Name: "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExtendingThreadClass t1 = new ExtendingThreadClass();
        t1.start();

    }
}

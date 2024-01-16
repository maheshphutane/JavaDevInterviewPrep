package org.example.multithreading;

public class extendingThreadClass extends Thread{
    public void run(){
        System.out.println("In Thread class");
    }

    public static void main(String[] args) {
        extendingThreadClass t1 = new extendingThreadClass();
        t1.start();

    }
}

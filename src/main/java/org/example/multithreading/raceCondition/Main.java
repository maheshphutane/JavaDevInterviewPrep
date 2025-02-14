package org.example.multithreading.raceCondition;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Counter cnt = new Counter();

        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for(int i = 0;i<1000;i++){
                cnt.increment(1);
            }
        });

        Thread t2 = new Thread(()->{
            for(int i = 0;i<1000;i++){
                cnt.decrement(1);
            }
        });

        t1.start();
        t2.start();
//        t1.join();
//        t2.join();

        System.out.println(cnt.getCnt());
    }
}

package org.example.multithreading.raceCondition;

public class MainSynchronizedMethode {
    //Points to be noted
    //synchronized keyword when used with methode then it will take class level lock
    //and if it is used as synchronized block over specific object
    public static void main(String[] args) {
        CounterSynchronizedMethode tmp = new CounterSynchronizedMethode();
        CounterSynchronizedMethode tmp2 = new CounterSynchronizedMethode();
        Thread t1 = new Thread(()->{
            for(int i = 0;i<1000;i++){
                tmp.increment(1);
            }
        });

        Thread t2 = new Thread(()->{
            for(int i = 0;i<1000;i++){
                tmp2.decrement(1);
            }

        });


        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(tmp.getCnt());
        System.out.println(tmp2.getCnt());
    }

}

package org.example.multithreading.raceCondition;

public class CounterSynchronizedMethode {
    static int cnt = 0;
    public static synchronized  void increment(int i){// when we use synchronized keyword for static methode then
                                                        // it will be considered as class level lock
            cnt+=i;
    }

    public static synchronized  void decrement(int i){
            cnt-=i;
    }

    public int getCnt(){
        return cnt;
    }

}

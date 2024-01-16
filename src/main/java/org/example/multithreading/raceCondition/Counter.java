package org.example.multithreading.raceCondition;
class Counter {
    Integer cnt = 0;
    public void increment(int i){
        synchronized (cnt){        // Here we are putting object/data member level lock for Integer cnt
            this.cnt+=i;           // we can use synchronized(this) to get object level to avoid race condition
        }
    }

    public void decrement(int i){
        synchronized (cnt){
            this.cnt-=i;
       }
    }

    public int getCnt(){
        return this.cnt;
    }
}

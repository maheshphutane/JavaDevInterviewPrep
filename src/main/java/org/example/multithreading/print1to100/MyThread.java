package org.example.multithreading.print1to100;

public class MyThread extends Thread{
    static volatile int counter = 1;
    static final int MAX_THREDS = 10;
    public static Object obj = new Object();
    int id;
    public MyThread(int id){
        this.id = id;
    }
    @Override
    public void run(){
        synchronized (obj){
            while (counter<=100){
                if(counter==id || counter%MAX_THREDS == id || (counter%MAX_THREDS==0 && MAX_THREDS==id)){
                    System.out.println("Thread: "+id+" printing "+counter);
                    counter+=1;
                    obj.notifyAll();
                }else{
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        for(int i = 1;i<=MAX_THREDS;i++){
            MyThread t = new MyThread(i);
            t.start();
        }
    }
}

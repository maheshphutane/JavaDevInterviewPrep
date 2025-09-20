package org.example.multithreading.print1to100;

public class EvenOdd extends Thread{
    volatile static int count = 1;
    static Object obj = new Object();
    int id;
    public EvenOdd(int id){
        this.id = id;
    }
    @Override
    public void run(){
        synchronized(obj){
            while(count<=100){
                if(count%2!=0 && id==1){
                    System.out.println("T "+id+" : "+count);
                    count++;
                    obj.notify();
                } else if (count%2==0 && id == 2) {
                    System.out.println("T "+id+" : "+count);
                    count++;
                    obj.notify();
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
        EvenOdd t1 = new EvenOdd(1);
        EvenOdd t2 = new EvenOdd(2);

        t1.start();
        t2.start();
    }
}

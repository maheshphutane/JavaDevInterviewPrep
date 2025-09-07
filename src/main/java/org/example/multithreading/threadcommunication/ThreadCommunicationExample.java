package org.example.multithreading.threadcommunication;

import java.util.ArrayDeque;
import java.util.Queue;

class SharedResource{
    private int QUEUE_SIZE;
    public SharedResource(int queueSize){
        this.QUEUE_SIZE = queueSize;
    }
    private Queue<Integer> queue = new ArrayDeque<>();


    public synchronized void produce(int data) {
        while(QUEUE_SIZE==5){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        this.queue.offer(data);
        QUEUE_SIZE++;
        notify();
        System.out.println("Data : "+ data +" is Produced by Thread "+Thread.currentThread().getName());

    }
    public synchronized int consume(){
        while(QUEUE_SIZE==0){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        QUEUE_SIZE--;
        int data = queue.poll();
        System.out.println("Data : "+ data +" is Consumed by Thread "+Thread.currentThread().getName());
        notify();
        return data;
    }
}

class Producer implements Runnable{
    private SharedResource sharedResource;
    public Producer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        for(int i = 0;i<10;i++){
            sharedResource.produce(i);
        }
    }
}

class Consumer implements Runnable{
    private final SharedResource sharedResource;
    public Consumer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        for(int i = 0;i<10;i++){
            sharedResource.consume();
        }
    }
}
public class ThreadCommunicationExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(10);
        Thread produce = new Thread(new Producer(sharedResource));
        Thread consume = new Thread(new Consumer(sharedResource));
        produce.start();
        consume.start();
    }

}

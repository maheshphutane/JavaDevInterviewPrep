package org.example.ThreadSequence3;

public class NumberGenerator {
    private int number = 1;
    private int numberOfThreads;
    private int totalNumbersInSequence;

    public NumberGenerator(int numberOfThreads, int totalNumbersInSequence) {
        this.numberOfThreads = numberOfThreads;
        this.totalNumbersInSequence = totalNumbersInSequence;
    }

    public void printNumbers(int result){
        synchronized (this){
            while (number<totalNumbersInSequence-numberOfThreads +2){// to print upto exact number
                while(number%numberOfThreads != result){
                    try {
                        wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" "+number++);
                notifyAll();
            }
        }
    }
}

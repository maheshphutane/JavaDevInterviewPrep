package org.example.ThreadSequence3;

import java.util.Scanner;

public class ThreadSequence3{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfThreads = sc.nextInt();
        int sequence = sc.nextInt();

        NumberGenerator numberGenerator = new NumberGenerator(noOfThreads,sequence);

        Thread[] threadPool = new Thread[noOfThreads];

        for(int i = 0;i<noOfThreads;i++){
            threadPool[i] = new Thread(new SequenceGenerator(numberGenerator,(i+1)%noOfThreads),"Thread-"+(i+1));
        }

        for(int i = 0;i<noOfThreads;i++){
            threadPool[i].start();
        }

    }

}

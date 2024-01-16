package org.example.cursors;

import java.util.*;

public class IteratorC {
    public static void main(String[] args) {
        //Iterator for list
        ArrayList<Integer> ls = new  ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        Iterator iter = ls.iterator();
        while(iter.hasNext()){
            Integer tmp = (Integer) iter.next();
            if(tmp%2==0) {
                System.out.println(tmp);
            }
            else {
                iter.remove();
            }
        }
        System.out.println(ls);
        //We cannot use iterator on map


    }
}

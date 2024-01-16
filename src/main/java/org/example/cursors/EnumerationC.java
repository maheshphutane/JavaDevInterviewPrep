package org.example.cursors;

import java.util.*;
//Enumeration is only applicable for legacy classes like vector,stack,hashtable
//We only have read access
public class EnumerationC {

    public static void main(String[] args) {
        Vector<Integer> tmp = new Vector<>();
        tmp.add(1);
        tmp.add(2);

        Enumeration e = tmp.elements();

        while(e.hasMoreElements()){
            System.out.println((Integer)e.nextElement());
        }

        //Enumeration of list
        List<Integer> ls = Arrays.asList(3,4,5);
        Enumeration<Integer> eList = Collections.enumeration(ls);
        while(eList.hasMoreElements()){
            System.out.println((Integer)eList.nextElement());
        }

    }

}

package org.example.cursors;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
// List iterator is most powerful cursor but it is only applicable
// for list implementing classes like.. arraylist,linked-list
public class ListIteratorDemo {
    public static void main(String[] args) {
        List ls = new ArrayList();
        ls.add(1);
        ls.add(2);
        ls.add(3);

        ListIterator listIterator1 = ls.listIterator();

        while (listIterator1.hasNext()){
            int tmp = (Integer) listIterator1.next();
            listIterator1.set(5);
            listIterator1.add(tmp*10);
            System.out.println(tmp);
        }
        System.out.println(ls);
    }
}

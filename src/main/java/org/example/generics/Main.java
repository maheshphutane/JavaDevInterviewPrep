package org.example.generics;

public class Main {
    public static void main(String[] args) {
        //using generics
        //No explicit type casting
        Printer<Integer> obj1 = new Printer<>(10);
        Printer<String> obj2 = new Printer<>("Mahesh");
        obj1.print();
        obj2.print();

        //using Object class
        GenericsUsingObjectClass obj3 = new GenericsUsingObjectClass("Phutane");
        GenericsUsingObjectClass obj4 = new GenericsUsingObjectClass(12.4);
        obj3.print();
        obj4.print();
    }
}

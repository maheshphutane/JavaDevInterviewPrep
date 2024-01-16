package org.example.inheritance;

public class Main {
    public static void main(String[] args) {
        BaseClass bc = new BaseClass();
        SuperClass sc = new BaseClass();
       // BaseClass bc2 = new SuperClass();
        sc.staticPrint(); // if we override static methode in base class then i
                            // t will call super class methode if the reference is of super class
        bc.staticPrint();
        SuperInterface si = new BaseClass();
        System.out.println(bc.age);
        System.out.println(sc.name);
        si.printName();
    }
}
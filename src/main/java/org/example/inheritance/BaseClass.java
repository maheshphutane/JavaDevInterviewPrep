package org.example.inheritance;

public class BaseClass extends SuperClass implements SuperInterface{
    int age;
    public BaseClass(){

        age = 10;
    }
    static void staticPrint(){
        System.out.println("Printing from Base class");
    }
    public void printName(){
        System.out.println("In implemented Base Class");
    }
}

package org.example.inheritance;

public class SuperClass {
    String name;
    public SuperClass(String name){
        this.name = name;
        System.out.println("My name is" +name);
    }
    static void staticPrint(){
        System.out.println("Printing from super class");
    }
    public SuperClass(){
        System.out.println("Default Constructor called");
    }
}

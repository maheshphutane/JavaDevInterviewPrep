package org.example.designPatterns.creational.PrototypeDesignPattern;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeRegistry cache = new PrototypeRegistry();
        cache.loadData();
        Profession student1 = cache.getObj("Student");
        Profession student2 = cache.getObj("Student");
        student1.print();
        System.out.println(student1);
        System.out.println(student2);
    }
}

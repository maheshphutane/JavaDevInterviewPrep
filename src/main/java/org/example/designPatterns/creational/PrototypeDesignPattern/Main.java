package org.example.designPatterns.creational.PrototypeDesignPattern;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeRegistry cache = new PrototypeRegistry();
        cache.loadData();
        Profession student1 = cache.getObj("Student");
        Profession student2 = cache.getObj("Student");
        Profession doctor = cache.getObj("Doctor");
        student1.print();
        doctor.print();
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(doctor);
    }
}

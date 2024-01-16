package org.example.designPatterns.creational.builderDesignPattern;

public class builderMain {
    public static void main(String[] args) {
        Phone obj1 = new phoneBuilder().setCompany("Samsung").setBattery(5000).getPhone();
        System.out.println(obj1);
    }
}

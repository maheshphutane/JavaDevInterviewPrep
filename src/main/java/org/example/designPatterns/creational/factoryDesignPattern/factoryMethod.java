package org.example.designPatterns.creational.factoryDesignPattern;

public class factoryMethod {
    public static void main(String[] args) {
        ObjectFactory factory = new ObjectFactory();
        OS obj1 = factory.getObject("Android");
        obj1.spec();
        OS obj2 = factory.getObject("Windows");
        obj2.spec();
        OS obj3 = factory.getObject("Mac");
        obj3.spec();
    }

}

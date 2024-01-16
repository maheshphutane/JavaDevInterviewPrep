package org.example.designPatterns.creational.SingletoneDesignPattern;

// Enums are by default follows singleton behaviour
public enum SingletonEnum {
    SINGLETON_ENUM;
    public void doSomething(){
        System.out.println("In Enum");
    }

}

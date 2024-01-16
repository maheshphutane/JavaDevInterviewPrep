package org.example.designPatterns.structural.ProxyDesignPattern;

public class ProxyClass extends OriginalClass {
    @Override
    public void methode(){
        System.out.println("You are now in Proxy class.\n" +
                "we will first authenticate you and then give access to real object.");
        super.methode();
    }
}

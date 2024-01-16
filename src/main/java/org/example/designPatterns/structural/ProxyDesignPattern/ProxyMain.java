package org.example.designPatterns.structural.ProxyDesignPattern;

public class ProxyMain {
    public static void main(String[] args) {
        OriginalInterface proxy = new ProxyClass();
        proxy.methode();
    }
}

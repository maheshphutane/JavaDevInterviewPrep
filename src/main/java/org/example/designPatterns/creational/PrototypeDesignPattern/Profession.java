package org.example.designPatterns.creational.PrototypeDesignPattern;

public abstract class Profession implements Cloneable{
    abstract void print();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

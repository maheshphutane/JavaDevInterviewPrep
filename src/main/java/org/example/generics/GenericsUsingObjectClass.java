package org.example.generics;

public class GenericsUsingObjectClass {
    Object objToPrint;
    public GenericsUsingObjectClass(Object objToPrint){
        this.objToPrint = objToPrint;
    }

    public void print(){
        System.out.println(this.objToPrint);
    }
}

package org.example.designPatterns.creational.factoryDesignPattern.SimpleFactory;

public class ObjectFactory {
    public OS getObject(String type){
        if(type=="Android"){
            return new Android();
        }else if(type=="Windows"){
            return new Windows();
        }else{
            return new Mac();
        }
    }
}

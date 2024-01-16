package org.example.designPatterns.creational.PrototypeDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {
    public static Map<String,Profession> objRegistry = new HashMap<>();
    public void loadData(){
        objRegistry.put("Student",new Student());
        objRegistry.put("Teacher",new Teacher());
        objRegistry.put("Doctor", new Doctor());
    }

    public Profession getObj(String profession) throws CloneNotSupportedException {
        Profession currProf = objRegistry.get(profession);
        return (Profession) currProf.clone();
    }
}

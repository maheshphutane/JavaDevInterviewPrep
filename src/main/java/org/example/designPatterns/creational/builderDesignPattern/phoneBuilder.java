package org.example.designPatterns.creational.builderDesignPattern;

public class phoneBuilder {
    private String company;
    private String ram;
    private int battery;
    private int camera;

    public phoneBuilder setCompany(String name){
        this.company = name;
        return this;
    }
    public phoneBuilder setRam(String ram){
        this.ram = ram;
        return this;
    }

    public phoneBuilder setCamera(int camera){
        this.camera = camera;
        return this;
    }

    public phoneBuilder setBattery(int battery){
        this.battery = battery;
        return this;
    }
    public Phone getPhone(){
        return new Phone(this.company,this.ram,this.battery,this.camera);
    }

}

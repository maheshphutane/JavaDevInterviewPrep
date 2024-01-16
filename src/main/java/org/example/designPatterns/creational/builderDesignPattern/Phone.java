package org.example.designPatterns.creational.builderDesignPattern;

public class Phone {
    private String company;
    private String ram;
    private int battery;
    private int camera;
    public Phone(String company, String ram, int battery, int camera) {
        this.company = company;
        this.ram = ram;
        this.battery = battery;
        this.camera = camera;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "company='" + company + '\'' +
                ", ram='" + ram + '\'' +
                ", battery=" + battery +
                ", camera=" + camera +
                '}';
    }

}

package org.example;

public class Employee {
    int salary;
    String name;
    String email;

    public Employee(int id, String name, String email) {
        this.salary = id;
        this.name = name;
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

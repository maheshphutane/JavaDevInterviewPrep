package org.example;

public class Employee1 {
    int id;
    String name;
    double salary;

    public Employee1(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int hashCode(){
        int cnt = this.getId()*10;
        return cnt;
    }

    @Override
    public boolean equals(Object obj){
        if(obj==this) return true;
        Employee1 currObj = (Employee1) obj;
        if(currObj.id==this.id
                && currObj.salary==this.salary
                && currObj.name.equals(this.name)){
            return true;
        }
        return false;
    }

}

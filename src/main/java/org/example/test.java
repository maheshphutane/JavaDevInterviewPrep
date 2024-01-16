package org.example;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Employee1 e1 = new Employee1(1,"ram",200000);
        Employee1 e2 = new Employee1(1,"ram",200000);
        Employee1 e3 = new Employee1(3,"anuj",500000);

        List<Employee1> employee1List = Arrays.asList(e1,e2,e3);

        Employee1 empWithMaxSal = employee1List.stream()
                .sorted((a,b)->b.getName().length()-a.getName().length()).findFirst().get();

        System.out.println(empWithMaxSal);
        Set<Employee1> tmpSet = new HashSet<>();
        tmpSet.add(e1);
        tmpSet.add(e2);
        tmpSet.add(e3);
        System.out.println(tmpSet);
        //get Employee
    }
}

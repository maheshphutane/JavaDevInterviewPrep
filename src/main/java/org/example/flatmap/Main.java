package org.example.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", Arrays.asList("Java", "Python", "SQL")),
                new Employee("Emily", Arrays.asList("JavaScript", "HTML", "CSS")),
                new Employee("Robert", Arrays.asList("Java", "C++", "Python"))
        );

        List<String> uniqueSkills = employees.stream()
                .flatMap(employee -> employee.getSkills().stream()) // Flattens the list of skills into a single stream
                .distinct() // Get distinct skills
                .collect(Collectors.toList());

        System.out.println(uniqueSkills);
    }
}

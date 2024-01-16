package org.example.flatmap;

import java.util.List;

class Employee {
    private String name;
    private List<String> skills;

    public Employee(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    public List<String> getSkills() {
        return skills;
    }
}
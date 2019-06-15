package com.bamboo.organization.model;
import lombok.Data;

import java.util.List;
import java.util.ArrayList;

@Data
public class Department {
    private Long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Department() {

    }

    public Department(String name) {
        super();
        this.name = name;
    }

}

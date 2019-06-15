package com.bamboo.organization.model;
import lombok.Data;

import java.util.List;
import java.util.ArrayList;

@Data
public class Organization {
    private Long id;
    private String name;
    private String address;
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public Organization() {

    }

    public Organization(String name, String address) {
        this.name = name;
        this.address = address;
    }

}

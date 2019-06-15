package com.bamboo.organization.controller;

import com.bamboo.organization.model.Organization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bamboo.organization.repository.OrganizationRepository;
import com.bamboo.organization.client.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/organization")
public class OrganizationController {
    private OrganizationRepository repository;
    private DepartmentClient departmentClient;
    private EmployeeClient employeeClient;

    public OrganizationController(OrganizationRepository repository,
                                  DepartmentClient departmentClient,
                                  EmployeeClient employeeClient )
    {
        this.repository = repository;
        this.departmentClient = departmentClient;
        this.employeeClient = employeeClient;
    }

    @PostMapping
    public Organization add(@RequestBody Organization organization) {
        log.info("Organization add: {}", organization);
        return repository.add(organization);
    }

    @GetMapping
    public List<Organization> findAll() {
        log.info("Organization find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable("id") Long id) {
        log.info("Organization find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/{id}/with-departments")
    public Organization findByIdWithDepartments(@PathVariable("id") Long id) {
        log.info("Organization find: id={}", id);
        Organization organization = repository.findById(id);
        organization.setDepartments(departmentClient.findByOrganization(organization.getId()));
        return organization;
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
        log.info("Organization find: id={}", id);
        Organization organization = repository.findById(id);
        organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
        return organization;
    }

    @GetMapping("/{id}/with-employees")
    public Organization findByIdWithEmployees(@PathVariable("id") Long id) {
        log.info("Organization find: id={}", id);
        Organization organization = repository.findById(id);
        organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
        return organization;
    }

}

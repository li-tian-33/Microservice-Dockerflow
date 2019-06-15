package com.bamboo.employee.controller;
import com.bamboo.employee.Repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bamboo.employee.model.Employee;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {
    private EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository)
    {
        this.repository = repository;
    }

    @PostMapping("/")
    public Employee add(@RequestBody Employee employee) {
        log.info("Employee add: {}", employee);
        return repository.add(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        log.info("Employee find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/")
    public List<Employee> findAll() {
        log.info("Employee find");
        return repository.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        log.info("Employee find: departmentId={}", departmentId);
        return repository.findByDepartment(departmentId);
    }

    @GetMapping("/organization/{organizationId}")
    public List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId) {
        log.info("Employee find: organizationId={}", organizationId);
        return repository.findByOrganization(organizationId);
    }


}

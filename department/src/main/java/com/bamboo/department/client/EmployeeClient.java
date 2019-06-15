package com.bamboo.department.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import com.bamboo.department.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name="employee-service")
public interface EmployeeClient {
    @GetMapping("/department/{departmentId}")
     List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);
}

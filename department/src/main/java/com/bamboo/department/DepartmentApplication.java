package com.bamboo.department;

import com.bamboo.department.model.Department;
import com.bamboo.department.repository.DepartmentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class DepartmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentApplication.class, args);
    }


    @Bean
    DepartmentRepository repository() {
        DepartmentRepository repository = new DepartmentRepository();
        repository.add(new Department(1L, "Development"));
        repository.add(new Department(1L, "Operations"));
        repository.add(new Department(2L, "Development"));
        repository.add(new Department(2L, "Operations"));
        return repository;
    }

}

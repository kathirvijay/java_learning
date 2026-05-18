package com.example.javalearning.controller.repository;

import com.example.javalearning.controller.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Employee_repo extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByNameIgnoreCase(String name);
}

package com.example.javalearning.repository;

import com.example.javalearning.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Employee_repo extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByNameIgnoreCase(String name);
}

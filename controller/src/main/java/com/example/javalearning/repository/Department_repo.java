package com.example.javalearning.repository;

import com.example.javalearning.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Department_repo extends JpaRepository<Department, Integer> {
    Optional<Department> findByDeptName(String deptName);
}

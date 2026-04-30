package com.example.javalearning.controller.repository;

import com.example.javalearning.controller.entity.User_entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_repository extends JpaRepository<User_entity, Integer> {
}

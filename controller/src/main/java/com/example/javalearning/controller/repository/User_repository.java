package com.example.javalearning.controller.repository;

import com.example.javalearning.controller.entity.User_entity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface User_repository extends JpaRepository<User_entity, Integer> {

    @Query("SELECT U FROM User_entity U WHERE U.name LIKE %:name%")
    List<User_entity> searchByName(String name, Pageable pageble);
}

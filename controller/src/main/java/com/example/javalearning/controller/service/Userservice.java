package com.example.javalearning.controller.service;

import com.example.javalearning.controller.component.User;
import com.example.javalearning.controller.entity.User_entity;
import com.example.javalearning.controller.repository.User_repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice {
    public User user;

    public final User_repository repo;

    public Userservice(User_repository userRepo, User user){
        this.repo = userRepo;
        this.user = user;
    }

    public User_entity Usercreate(User_entity user) {
        return repo.save(user);
    }

    public ApiResponce<?> getAllUser() {
        List<User_entity> data = repo.findAll();

        ApiResponce res = new ApiResponce();
        if (data.isEmpty()) {
            res.setMessage("No data to show!!!");
            res.setData(null);
            res.setSuccess(true);
            return res;
        } else {
            res.setMessage("List of users returned successfully!!!");
            res.setData(res);
            res.setSuccess(true);
            return res;
        }
    }
}


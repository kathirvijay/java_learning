package com.example.javalearning.controller.service;

import com.example.javalearning.controller.component.User;
import com.example.javalearning.controller.entity.User_entity;
import com.example.javalearning.controller.repository.User_repository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            res.setData(data);
            res.setSuccess(true);
            return res;
        }
    }

    public ApiResponce<?> findUserById(int Id) {
        Optional<User_entity> data = repo.findById(Id);

        ApiResponce res = new ApiResponce();

        if(data.isPresent()){
            res.setMessage("User has been identified !!!");
            res.setSuccess(true);
            res.setData(data);
        } else {
            res.setMessage("No such user records !!!");
            res.setSuccess(true);
            res.setData(null);
        }
        return res;
    }

    public ApiResponce<?> searchByName(String name, int page, int size){
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        List<User_entity> data = repo.searchByName(name, pageable);

        ApiResponce res = new ApiResponce();

        if(!data.isEmpty()){
            res.setMessage("User with that records identified !!!");
            res.setSuccess(true);
            res.setData(data);
        } else {
            res.setMessage("No User matches in our record !!!");
            res.setSuccess(true);
            res.setData(null);
        }
        return res;
    }
}


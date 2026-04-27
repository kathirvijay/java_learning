package com.example.javalearning.controller.service;

import com.example.javalearning.controller.component.User;
import org.springframework.stereotype.Service;

@Service
public class Userservice {
    public User user;

//    public Userservice(User user) {
//        this.user = user;
//    }

    public String getUser() {
        if (user == null) {
            return "No user has been created yet!";
        }
        return "The User " + user.getName() + " of age " + user.getAge() +
                " living in " + user.getPlace() +
                " has provided user id " + user.getUser_no();
    }

    public String Usercreate(User user) {
//        this.user.setName(user.getName());
//        this.user.setAge(user.getAge());
//        this.user.setUser_no(user.getUser_no());
//        this.user.setPlace(user.getPlace());
        this.user = user;
        return this.user.getName() + " Has been created successfully !!!";
    }

}


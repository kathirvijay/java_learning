package com.example.javalearning.controller.Usercontroller;


import com.example.javalearning.controller.component.User;
import com.example.javalearning.controller.service.Userservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usercontroller {

    public Userservice userService;

    public Usercontroller(Userservice userService){
        this.userService = userService;
    }

    @GetMapping("/health")
    public String health(){
        return "Service is working fine !!!";
    }

    @GetMapping("/welcome")
    public String welcomeUser(){
        return "welcome user to our project!!!";
    }

    @GetMapping("/user")
    public String getUser(){
        return this.userService.getUser();
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user){
        return this.userService.Usercreate(user);
    }


}

package com.example.javalearning.controller.Usercontroller;


import com.example.javalearning.controller.component.Health;
import com.example.javalearning.controller.component.User;
import com.example.javalearning.controller.entity.User_entity;
import com.example.javalearning.controller.model.Usermodel;
import com.example.javalearning.controller.service.ApiResponce;
import com.example.javalearning.controller.service.Userservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Usercontroller {

    public Userservice userService;

    public Usercontroller(Userservice userService){
        this.userService = userService;
    }

    @GetMapping("/health")
    public ResponseEntity<Health<User>> health(){
        User user = new User();
        user.setUser_no(1);
        user.setName("pradee");
        user.setAge(28);
        user.setPlace("CBE");

        Health health = new Health();
        health.setName(user.getName());
        health.setPercentage(100);
        health.setState("Protected");
        health.setData(user);

        return ResponseEntity.status(200).body(health);
    }

    @GetMapping("/welcome")
    public ResponseEntity<ApiResponce<User>>  welcomeUser(){
       ApiResponce responce = new ApiResponce();
       responce.setSuccess(true);
       responce.setMessage("welcome to system !!!");
       responce.setData( "added successfully");
       return ResponseEntity.status(200).body(responce);
    }

    @GetMapping("/mock-user")
    public ResponseEntity<ApiResponce<User>> mockUser(){
        User user = new User();
        user.setName("Kathir");
        user.setAge(25);
        ApiResponce<User> response = new ApiResponce();
        response.setSuccess(true);
        response.setMessage("data fetched successfully");
        response.setData(user);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/user")
    public User_entity createUser(@RequestBody User_entity user){
        return this.userService.Usercreate(user);
    }

    @GetMapping("/alluser")
    public ResponseEntity<ApiResponce<?>> getUser(){
        return ResponseEntity.status(200).body(this.userService.getAllUser());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        if(id == 0){
            return ResponseEntity.badRequest().body("Nop search results matches your case !!!");
        }
        return ResponseEntity.status(200).body(this.userService.findUserById(id));
    }

    @PostMapping("/search")
    public ResponseEntity<ApiResponce<?>> searchByName(@RequestParam String name ){
//        System.out.println("data "+ name+" "+ page + " " + size);
        return ResponseEntity.status(200).body(this.userService.searchByName(name, 0, 5));
    }
}

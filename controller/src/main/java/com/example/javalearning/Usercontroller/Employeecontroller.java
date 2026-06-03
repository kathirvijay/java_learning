package com.example.javalearning.Usercontroller;


import com.example.javalearning.entity.Employee;
import com.example.javalearning.service.ApiResponce;
import com.example.javalearning.service.Employee_service;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class Employeecontroller {
    public Employee_service employeeService ;

    private Employeecontroller(Employee_service empService){
        this.employeeService = empService;
    }

    @PostMapping("/employee")
    public ResponseEntity<ApiResponce<?>> createEmployee(@Valid @RequestBody  Employee employee){
        return ResponseEntity.status(200).body(this.employeeService.employeeSave(employee));
    }

    @GetMapping("/getAllEmp")
    public ResponseEntity<ApiResponce<List<Employee>>> getAllEmployee(){
        return ResponseEntity.status(200).body(this.employeeService.getAllEmployee());
    }

    @GetMapping("/findEmployee")
    public ResponseEntity<ApiResponce<?>> findEmployee(@Valid @RequestParam String emp_name){
        return ResponseEntity.status(200).body(this.employeeService.findEmployee(emp_name));
    }


}

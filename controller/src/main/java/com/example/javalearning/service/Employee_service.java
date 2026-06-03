package com.example.javalearning.service;


import com.example.javalearning.Exceptions.SafeDataHandeller;
import com.example.javalearning.Exceptions.UserNotFoundException;
import com.example.javalearning.entity.Department;
import com.example.javalearning.entity.Employee;
import com.example.javalearning.repository.Department_repo;
import com.example.javalearning.repository.Employee_repo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Employee_service {
    private final Employee_repo employee_repo;
    private final Department_repo deptRepo;
    private Employee_service(Employee_repo employeeRepo, Department_repo deptRepo){
        this.employee_repo = employeeRepo;
        this.deptRepo = deptRepo;
    }

    public ApiResponce<?> employeeSave(Employee employee){
        ApiResponce res = new ApiResponce();
        try{
            Optional<Employee> existingEmployee = employee_repo.findByNameIgnoreCase(employee.getName());

            if (existingEmployee.isPresent()){
                res.setSuccess(false);
                res.setMessage("Employee name already exists !!!");
            } else {
                Department dept = deptRepo.findByDeptName(
                        employee.getDepartment().getDeptName()
                ).orElseThrow(() -> new RuntimeException("No department with ID exist !!!"));
                employee.setDepartment(dept);
                Employee data = employee_repo.save(employee);

                System.out.println("Saved Employee: " + data);
                if(data != null){
                    res.setMessage("Employee created successfully !!!");
                    res.setSuccess(true);
                    res.setData(data);
                } else{
                    res.setMessage("Employee creation failed !!!");
                    res.setSuccess(true);
                }
            }

        } catch(Exception e) {
            res.setMessage(String.valueOf(e.getMessage()));
            res.setSuccess(false);
        }

        return res;
    }

    public ApiResponce<List<Employee>> getAllEmployee() {
        ApiResponce res = new ApiResponce();

        try{
            List<Employee> data = employee_repo.findAll();
            if(!data.isEmpty()){
                res.setData(data);
                res.setSuccess(true);
                res.setMessage("All employee detils Fetched !!!");
            } else {
                res.setData(null);
                res.setSuccess(true);
                res.setMessage("No Employee details !!!");
            }
        } catch (Exception e){
            res.setMessage(e.getMessage());
            res.setSuccess(false);
        }

        return res;
    }

    public ApiResponce<?> findEmployee(String empName){
        ApiResponce res = new ApiResponce();
        try{
            if(empName.trim().isEmpty()){
                throw new SafeDataHandeller("Data is not present in param");
            }
            Employee data = employee_repo.findByNameIgnoreCase(empName).orElseThrow(() -> new UserNotFoundException(empName +" is Not avaliable in entire records !!!"));;

            res.setSuccess(true);
            res.setData(data);
            res.setMessage("User has been registered in our DB !!!");
        } catch( UserNotFoundException e){
            res.setMessage("Error : " + e.getMessage());
            res.setData(null);
            res.setSuccess(false);
        } catch (Exception e){
            res.setMessage("UnNoticed Error : " + e.getMessage());
            res.setData(null);
            res.setSuccess(false);
        }
        return res;
    }
}

package com.example.javalearning.controller.service;

import com.example.javalearning.controller.repository.Employee_repo;
import org.springframework.stereotype.Service;

public class ApiResponce<T>{
    private Boolean Success;
    private String message;
    private T data;

    public Boolean getSuccess() {
        return Success;
    }

    public void setSuccess(Boolean success) {
        Success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

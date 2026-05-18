package com.example.javalearning.controller.Exceptions;

public class SafeDataHandeller extends RuntimeException {
    public SafeDataHandeller(String message) {
        super(message);
    }
}

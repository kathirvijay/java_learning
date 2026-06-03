package com.example.javalearning.Exceptions;

public class SafeDataHandeller extends RuntimeException {
    public SafeDataHandeller(String message) {
        super(message);
    }
}

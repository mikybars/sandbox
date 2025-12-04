package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class GreeterServiceImpl implements GreeterService {
    @Override
    public String greet(String user) {
        return "Hello " + user + "!";
    }
}

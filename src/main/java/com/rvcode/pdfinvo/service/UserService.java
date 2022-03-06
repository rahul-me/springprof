package com.rvcode.pdfinvo.service;

import com.rvcode.pdfinvo.model.User;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    public User findById(String id){
        String name = UUID.randomUUID().toString();
        return new User(id, name);
    }
}

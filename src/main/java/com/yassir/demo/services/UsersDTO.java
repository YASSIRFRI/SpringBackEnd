package com.yassir.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassir.demo.repositories.UserRepository;

@Service
public class UsersDTO {
    @Autowired
    private UserRepository userRepository;
     
    public ArrayList<com.yassir.demo.entities.User> getAllUsers() {
        ArrayList<com.yassir.demo.entities.User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    
}

package com.yassir.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassir.demo.entities.User;
import com.yassir.demo.repositories.UserRepository;

import lombok.Data;

@Service
@Data
public class RegisterService {


    @Autowired
    private UserRepository userRepository;

    public boolean register(String fname, String lname, String email, String password) {
        try{
            userRepository.save(new User(null,fname, lname, email, password)); 
            return true;
        }
        catch(Exception e)
        {
            return false;
        }

    }
    
}

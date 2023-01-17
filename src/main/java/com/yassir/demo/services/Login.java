package com.yassir.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassir.demo.entities.User;
import com.yassir.demo.repositories.UserRepository;

import Dto.UserDto;



@Service
public class Login {
    @Autowired
    private UserRepository userRepository;



    public UserDto login(String username, String password) {
        List<User> users= userRepository.findByFname(username);
        if(users.size()==0)
            return null;
        else
            if(users.get(0).getPassword().equals(password))
                return UserDto.toDTO(users.get(0));
            else
                return null;
    }
}

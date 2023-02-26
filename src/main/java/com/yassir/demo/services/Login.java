package com.yassir.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yassir.demo.entities.User;
import com.yassir.demo.repositories.UserRepository;
import com.yassir.demo.config.BCrypt;



@Service
public class Login {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder hasher;

    public User authenticate(String email, String password) throws Exception
    {
        List<User> users = userRepository.findByEmail(email);
        if(users.size() == 0)
        {
            throw new Exception("User not found");
        }
        User user = users.get(0);
        if(hasher.matches(password, user.getPassword()) == false)
        {
            throw new Exception("Invalid password");
        }
        return user;
    }
}

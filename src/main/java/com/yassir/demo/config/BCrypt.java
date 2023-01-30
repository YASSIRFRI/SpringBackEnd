package com.yassir.demo.config;


import java.beans.JavaBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@NoArgsConstructor
@JavaBean




public class BCrypt {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public  String hashPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public boolean checkPassword(String password, String hashed) {
        return bCryptPasswordEncoder.matches(password, hashed);
    }

    
}

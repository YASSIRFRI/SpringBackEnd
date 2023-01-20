package com.yassir.demo.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yassir.demo.config.BCrypt;
import com.yassir.demo.entities.User;
import com.yassir.demo.serializers.UserSerializer;
import com.yassir.demo.services.Login;
import com.yassir.demo.services.RegisterService;

import Dto.UserDto;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    private Login loginService;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private BCrypt bCryptPasswordEncoder;

    @Autowired
    private UserSerializer userSerializer; 



    @PostMapping("/login")
    public String login(@RequestBody String request) {
        User user= userSerializer.fromJson(request, User.class);
        UserDto usr= loginService.login(user.getFname(), user.getPassword());
        if(usr!=null)
        {
            return usr.getEmail();
        }
        else
        {
            return "Invalid Credentials";
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody String request) {
        User usr= userSerializer.fromJson(request, User.class);
        if(usr!=null)
        {
            return "User Registered";
        }
        else
        {
            return "User Not Registered";
        }
    }
}



    





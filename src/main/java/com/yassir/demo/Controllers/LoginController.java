package com.yassir.demo.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yassir.demo.entities.User;
import com.yassir.demo.services.Login;
import com.yassir.demo.services.RegisterService;

import Dto.UserDto;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {
    @Autowired
    private Login loginService;

    @Autowired
    private RegisterService registerService;



    @PostMapping("/login")
    public String login(@RequestBody User request) {
        UserDto usr= loginService.login(request.getFname(), request.getPassword());
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
    public String register(@RequestBody User request) {
        boolean usr= registerService.register(request.getFname(), request.getLname(), request.getEmail(), request.getPassword());
        if(usr)
        {
            return "User Registered";
        }
        else
        {
            return "User Not Registered";
        }
    }
}





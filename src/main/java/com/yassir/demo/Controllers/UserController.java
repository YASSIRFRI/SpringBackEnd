package com.yassir.demo.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yassir.demo.components.ContentSerializer;
import com.yassir.demo.components.UserSerializer;
import com.yassir.demo.config.BCrypt;
import com.yassir.demo.entities.Content;
import com.yassir.demo.entities.User;
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
    private ContentSerializer contentSerializer;

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
        boolean test= registerService.register(usr.getFname(), usr.getLname(), usr.getEmail(), usr.getPassword(),"USER");
        if(test)
        {
            return "User Registered";
        }
        else
        {
            return "User Not Registered";
        }
    }
    @PostMapping("/upgradeRole")
    public void addRoleToUser(String email, String roleName) {
        registerService.addRoleToUser(email, roleName);
    }

    @PostMapping("/myContent")
    public String myContent(@RequestBody String request) {
        Content content= contentSerializer.fromJson(request, Content.class);
        System.out.println(content);
        return "Content Added";
    }

}



    





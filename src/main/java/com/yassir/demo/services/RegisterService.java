package com.yassir.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassir.demo.entities.Role;
import com.yassir.demo.entities.User;
import com.yassir.demo.repositories.RoleRepository;
import com.yassir.demo.repositories.UserRepository;

import lombok.Data;

@Service
@Data
public class RegisterService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public boolean register(String fname, String lname, String email, String password) {

        try{
            User user = new User();
            user.setFname(fname);
            user.setLname(lname);
            user.setEmail(email);
            user.setPassword(password);
            userRepository.save(user);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public void addRoleToUser(String email, String roleName) {
        User user = userRepository.findByEmail(email).get(0);
        Role role = roleRepository.findByName(roleName).get(0);
        user.getRoles().add(role);
    }
    
}

package com.yassir.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yassir.demo.config.BCrypt;
import com.yassir.demo.entities.Content;
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

    @Autowired
    private EmailValidator emailValidator;

    @Autowired
    private BCrypt bCrypt;

    public boolean register(String fname, String lname, String email, String password, String role) {

        if(!emailValidator.isValid(email))
        {
            return false;
        }
        try{
            User user = new User();
            user.setFname(fname);
            user.setLname(lname);
            user.setEmail(email);
            user.setPassword(bCrypt.hashPassword(password));
            userRepository.save(user);
            return true;
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    public void addRoleToUser(String email, String roleName) {
        User user = userRepository.findByEmail(email).get(0);
        Role role = roleRepository.findByName(roleName).get(0);
        user.getRoles().add(role);
    }

    public void addContentToUser(String email, String about,String experience,String contact) {
        User user = userRepository.findByEmail(email).get(0);
        Content content = new Content();
        content.setAbout(about);
        content.setExperience(experience);
        content.setContact(contact);
        user.getContents().add(content);
    }
    
}

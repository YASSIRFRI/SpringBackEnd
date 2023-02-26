package com.yassir.demo.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yassir.demo.Requests.JwtRequest;
import com.yassir.demo.Requests.JwtResponse;
import com.yassir.demo.Requests.UserRequest;
import com.yassir.demo.components.ContentSerializer;
import com.yassir.demo.components.JwtTokenUtil;
import com.yassir.demo.components.UserSerializer;
import com.yassir.demo.config.BCrypt;
import com.yassir.demo.entities.User;
import com.yassir.demo.services.Login;
import com.yassir.demo.services.RegisterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




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
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserSerializer userSerializer; 


    @Autowired
    private JwtTokenUtil  jwtUtil;

    @GetMapping(value="/login")
    public String login(@RequestParam String username) {
        return "Hello " + username;
    }

    @PostMapping(value="/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        try{
            User user=loginService.authenticate(jwtRequest.getEmail(), jwtRequest.getPassword());
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        final String token = jwtUtil.generateToken(jwtRequest.getEmail());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping(value="/register")
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest) throws Exception{
        try{
            registerService.register(userRequest.getFname(), userRequest.getLname(), userRequest.getEmail(), userRequest.getPassword(), "USER");
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok("User registered successfully");
    }
    

    


   
}



    





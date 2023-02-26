package com.yassir.demo.Requests;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest implements Serializable {
    private String email;
    private String password;
    
}

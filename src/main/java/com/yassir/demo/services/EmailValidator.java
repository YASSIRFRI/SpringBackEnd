package com.yassir.demo.services;

import org.springframework.stereotype.Component;
import lombok.NoArgsConstructor;



@Component
@NoArgsConstructor
public class EmailValidator {
    public  boolean isValid(String email) {

        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";
        return email.matches(regex);
    }
}
package com.yassir.demo.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class RegistrationRequest {
    private String fname;
    private String lname;
    private String email;
    private String password;
}

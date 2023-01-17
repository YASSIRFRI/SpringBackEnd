package com.yassir.demo.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;



@Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class User {


    @JsonProperty("fname")
    private String fname;
    @JsonProperty("lname")
    private String lname;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    
}

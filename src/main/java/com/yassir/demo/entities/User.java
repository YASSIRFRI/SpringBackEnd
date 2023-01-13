package com.yassir.demo.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class User {
    private String username;
    private String password;
}

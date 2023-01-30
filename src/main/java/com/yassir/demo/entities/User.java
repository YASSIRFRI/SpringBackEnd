package com.yassir.demo.entities;


import java.util.ArrayList;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

import java.util.List;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class User {

    @Id 
    @GeneratedValue
    private UUID id;
    private String fname;
    private String lname;
    @Column(unique = true)
    private String email;
    private String password;



    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinTable(name="users_roles",
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="content_id"))
    private List<Content> contents = new ArrayList<>();



}
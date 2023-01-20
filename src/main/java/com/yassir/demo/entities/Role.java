package com.yassir.demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Roles")
@Data
@NoArgsConstructor
@lombok.AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,length = 20)
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;


    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

}

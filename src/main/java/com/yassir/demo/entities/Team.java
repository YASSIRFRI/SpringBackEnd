package com.yassir.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teams")
@Data @NoArgsConstructor @AllArgsConstructor
public class Team  {
    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long teamId;
    @Column(name = "team_name")
    private String teamName;
    @Column(name = "department")
    private String department;

    @ManyToMany
    @JoinTable(name = "users_teams",
    joinColumns = {@JoinColumn(name = "team_id")},
    inverseJoinColumns = {@JoinColumn(name = "user_email")})
    private Set<User> users;






    
}

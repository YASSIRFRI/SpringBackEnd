package com.yassir.demo.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yassir.demo.entities.User;




@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    List<User> findByFname(String fname);
    List<User> findByEmail(String email);
}

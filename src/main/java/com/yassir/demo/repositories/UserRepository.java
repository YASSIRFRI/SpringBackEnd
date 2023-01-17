package com.yassir.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yassir.demo.entities.User;




@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFname(String fname);
}

package com.yassir.demo.repositories;

import com.yassir.demo.entities.Role;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    List<Role> findByName(String name);
    Optional<Role> findById(Long id);
    

}

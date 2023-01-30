package com.yassir.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yassir.demo.entities.Content;







@Repository
public interface ContentRepository extends JpaRepository<Content, Long>{
    Content  findByUser(UUID id);
}

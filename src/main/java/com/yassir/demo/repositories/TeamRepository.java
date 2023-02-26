package com.yassir.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yassir.demo.entities.Team;





@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
    public Team findByTeamName(String teamName);
    public Team findByTeamId(Long teamid);
}

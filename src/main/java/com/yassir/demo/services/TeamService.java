package com.yassir.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassir.demo.entities.Team;
import com.yassir.demo.repositories.TeamRepository;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
import com.yassir.demo.entities.User;
@Service
@Data @NoArgsConstructor
public class TeamService {
    @Autowired
    TeamRepository teamRepository;


    public void createTeam(Team team) {
        teamRepository.save(team);
    }

    public Team getTeamById(Long id) {
        return teamRepository.findByTeamId(id);
    }

    public Team getTeamByName(String name) {
        return teamRepository.findByTeamName(name);
    }

    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }

    public Set<User> getUsersByTeamId(Long id) {
        return teamRepository.findByTeamId(id).getUsers();
    }   



    
}

package com.yassir.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yassir.demo.Requests.TeamRequest;
import com.yassir.demo.entities.Team;
import com.yassir.demo.repositories.TeamRepository;
import com.yassir.demo.services.TeamService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {


    @Autowired
    TeamService teamService;

    @PostMapping("/createTeam")
    public ResponseEntity<?> createTeam(@RequestBody TeamRequest team) {
        try{
            Team tm= new Team();
            tm.setTeamName(team.getTeamName());
            tm.setDepartment(team.getDepartment());
            teamService.createTeam(tm);
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body("Team already exists");
        }
        return ResponseEntity.ok("Team created");
    }

    @GetMapping("/team/{name}")
    public ResponseEntity<?> getTeamByName(@PathVariable String name) {
        Team team = teamService.getTeamByName(name);
        if(team == null) {
            return ResponseEntity.badRequest().body("Team not found");
        }
        return ResponseEntity.ok(team);
    }


    

    
}

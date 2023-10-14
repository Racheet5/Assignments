package com.assignment.player.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.player.model.Player;
import com.assignment.player.repository.Playerrepository;
import com.assignment.player.service.Playerservice;

import java.util.Optional;
import jakarta.persistence.EntityExistsException;




@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {
	
	
	@Autowired
	private Playerservice playerService;
	
	

	
	@PostMapping
    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        try {
            playerService.addPlayer(player);
            return ResponseEntity.status(HttpStatus.CREATED).body("Player added successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Player already exists");
        }
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }
	

}

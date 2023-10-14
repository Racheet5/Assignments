package com.assignment.player.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assignment.player.model.Player;
import com.assignment.player.repository.Playerrepository;

import jakarta.persistence.EntityExistsException;




@Service
public class PlayerImpl implements Playerservice{
	
	@Autowired
	private  Playerrepository playerRepository;
	
	
	@Override
    public void addPlayer(Player player) {
        if (playerRepository.existsByPlayerid(player.getPlayerid())) {
            throw new IllegalArgumentException("Player already exists");
        }
        playerRepository.save(player);
    }
	@Override
	public List<Player> getAllPlayers(){
		return playerRepository.findAll();
	}

	
	

}


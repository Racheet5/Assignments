package com.assignment.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.player.model.Player;



@Repository
public interface Playerrepository extends JpaRepository<Player,Integer> {

	boolean existsByPlayerid(Integer playerid);	
}

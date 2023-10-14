package com.assignment.player.service;
import com.assignment.player.model.Player;


import java.util.List;

import org.springframework.http.ResponseEntity;
public interface Playerservice {
   public void addPlayer(Player player);
   public List<Player> getAllPlayers();
   public Player deleteplayer(Integer id);
   public Player getplayer(Integer id);
   public Player updateplayer(Player player);
}

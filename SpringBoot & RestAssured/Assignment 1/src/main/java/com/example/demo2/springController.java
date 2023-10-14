package com.example.demo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/player")
public class springController {
	@GetMapping
    public String getAllPlayers() {
        return "All players returned";
    }
	@GetMapping("/{playerid}")
	public String getPlayerById(@PathVariable("playerid") Long playerId) {
        return "Player(" + playerId + ") returned";
    }
}

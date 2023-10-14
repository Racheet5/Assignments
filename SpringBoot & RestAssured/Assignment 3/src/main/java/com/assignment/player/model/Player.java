package com.assignment.player.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Player {
	@Id
	@Column(length = 20)
	private int playerid;
	@Column(length = 100)
	private String playername;
	@Column(length = 50)
	private String sports;
	@Column(length = 100)
	private String country;
	
	public Player() {
		super();
	}

	public Player(int playerid, String playername, String sports,String country) {
		super();
		this.playerid = playerid;
		this.playername = playername;
		this.sports = sports;
		this.country = country;
	}

	public int getPlayerid() {
		return playerid;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

	public String getSports() {
		return sports;
	}

	public void setSports(String sports) {
		this.sports = sports;
	}
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}

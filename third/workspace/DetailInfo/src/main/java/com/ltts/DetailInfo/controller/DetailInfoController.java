package com.ltts.DetailInfo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ltts.DetailInfo.model.Player;
import com.ltts.DetailInfo.model.Team;
import com.ltts.DetailInfo.model.combined;
@RestController
public class DetailInfoController {
	@Autowired
	RestTemplate rt;
	@Autowired
	RestTemplate pt;
	@Autowired
	RestTemplate lt;
	
	@RequestMapping("/detail")
	public List<Team> getExternalTeam()
	{
		ResponseEntity<Team[]> response=rt.getForEntity("http://team-service/teams", Team[].class);
		Team[] teams=response.getBody();
		List<Team> li=Arrays.asList(teams);
		return li;
	}
	
	@GetMapping("/details")
	public List<Player> getExternalPlayer()
	{
		ResponseEntity<Player[]> response=pt.getForEntity("http://player-service/player", Player[].class);
		Player[] Players=response.getBody();
		List<Player> li=Arrays.asList(Players);
		return li;
}
	


	
	
}
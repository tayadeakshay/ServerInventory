package com.pro.wings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro.wings.entity.ServerDetails;
import com.pro.wings.service.ServerService;


@RestController
@RequestMapping("/api/server")
public class ServerRestController {
	
	@Autowired
	ServerService serverService;
	
	@PostMapping
	public ResponseEntity<ServerDetails> save(@RequestBody ServerDetails server)
	{
		if(serverService.save(server))
		{
		return new ResponseEntity<ServerDetails>(server, HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<ServerDetails>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping
	public List<ServerDetails> getAllServers()
	{
		return serverService.getAllServerDetials();
	}
	
	@GetMapping("team")
	public List<ServerDetails> getServerByTeam(@RequestParam String team)
	{
			return serverService.getServerByTeam(team);
		
	}
	
	@GetMapping("team/environment")
	public List<ServerDetails> getServerByTeamEnv(@RequestParam(name = "team") String team,@RequestParam(name = "environment") String environment)
	{
		return serverService.getServerByTeamEnv(team,environment);
	}
	
	@GetMapping("team/environment/application")
	public List<ServerDetails> getServerByTeamEnvApp(@RequestParam(name = "team") String team,@RequestParam(name = "environment") String environment,@RequestParam(name = "application") String application)
	{
		return serverService.getServerByTeamEnvApp(team, environment, application);
	}
	
	@GetMapping("team/environment/application/isActive")
	public List<ServerDetails> getServerByTeamEnvAppActive(@RequestParam(name = "team") String team,@RequestParam(name = "environment") String environment,@RequestParam(name = "application") String application,@RequestParam(name="isActive") String isActive)
	{
		return serverService.getServerByTeamEnvAppActive(team, environment, application, isActive);
	}


}
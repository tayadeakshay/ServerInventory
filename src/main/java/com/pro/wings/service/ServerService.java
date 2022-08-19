package com.pro.wings.service;

import java.util.List;

import com.pro.wings.entity.ServerDetails;

public interface ServerService {

	public boolean save(ServerDetails server);
	
	public List<ServerDetails> getAllServerDetials();

	public List<ServerDetails> getServerByTeam(String team);
	
	public List<ServerDetails> getServerByTeamEnv(String team,String environment);
	
	public List<ServerDetails> getServerByTeamEnvApp(String team,String environment,String application);
	
	public List<ServerDetails> getServerByTeamEnvAppActive(String team,String environment,String application,String isActive);
}

package com.pro.wings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.wings.dao.ServerDao;
import com.pro.wings.entity.ServerDetails;



@Service
public class ServerServiceImpl implements ServerService{

	@Autowired
	ServerDao serverDao;
	
	@Override
	public boolean save(ServerDetails server) {
		
		return serverDao.save(server);
	}

	@Override
	public List<ServerDetails> getAllServerDetials() {

		return serverDao.getAllServerDetials();
	}

	@Override
	public List<ServerDetails> getServerByTeam(String team) {

		return serverDao.getServerByTeam(team);
	}

	@Override
	public List<ServerDetails> getServerByTeamEnv(String team, String environment) {

		return serverDao.getServerByTeamEnv(team, environment);
	}

	@Override
	public List<ServerDetails> getServerByTeamEnvApp(String team, String environment, String application) {

		return serverDao.getServerByTeamEnvApp(team, environment, application);
	}

	@Override
	public List<ServerDetails> getServerByTeamEnvAppActive(String team, String environment, String application,
			String isActive) {

		return serverDao.getServerByTeamEnvAppActive(team, environment, application, isActive);
	}

	
}

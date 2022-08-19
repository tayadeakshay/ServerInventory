package com.pro.wings.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.wings.entity.ServerDetails;

@Repository
public class ServerDaoImpl implements ServerDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean save(ServerDetails server) {

		try {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(server);
		
		tx.commit();
		session.close();
		System.out.println("Server details saved successfully");
		return true;
	}catch(Exception e){
		System.out.println("Could not update Server record");
		e.printStackTrace();
		return false;
		}
	}
	
	@Override
	public List<ServerDetails> getAllServerDetials() {
		
		try {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("From ServerDetails");
		
		List<ServerDetails> serverList = query.list();
		tx.commit();
		session.close();
		return serverList;
		}catch(Exception e){
			System.out.println("Could not get server record");
			e.printStackTrace();
			return null;
			}
	}

	@Override
	public List<ServerDetails> getServerByTeam(String team) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("From ServerDetails where team=:t");
			System.out.println(team);
			query.setParameter("t", team);
			List<ServerDetails> serverList = query.list();
			tx.commit();
			session.close();
			System.out.println("Server record returned for team" + team);
			return serverList;
			}catch(Exception e){
				System.out.println("Could not get server record");
				e.printStackTrace();
				return null;
				}
	}

	@Override
	public List<ServerDetails> getServerByTeamEnv(String team, String environment) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("From ServerDetails where team=:t and environment=:e");
			System.out.println(team);
			query.setParameter("t", team);
			query.setParameter("e", environment);
			List<ServerDetails> serverList = query.list();
			tx.commit();
			session.close();
			System.out.println("Server record returned for team and env :" + team +" and " +environment);
			return serverList;
			}catch(Exception e){
				System.out.println("Could not get server record");
				e.printStackTrace();
				return null;
				}
	}

	@Override
	public List<ServerDetails> getServerByTeamEnvApp(String team, String environment, String application) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("From ServerDetails where team=:t and environment=:e and application=:a");
			System.out.println(team);
			query.setParameter("t", team);
			query.setParameter("e", environment);
			query.setParameter("a", application);
			List<ServerDetails> serverList = query.list();
			tx.commit();
			session.close();
			System.out.println("Server record returned for team and env and application :" + team +" and " +environment+" and " +"application");
			return serverList;
			}catch(Exception e){
				System.out.println("Could not get server record");
				e.printStackTrace();
				return null;
				}
	}

	@Override
	public List<ServerDetails> getServerByTeamEnvAppActive(String team, String environment, String application,
			String isActive) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("From ServerDetails where team=:t and environment=:e and application=:a and isActive=:i");
			System.out.println(team);
			query.setParameter("t", team);
			query.setParameter("e", environment);
			query.setParameter("a", application);
			query.setParameter("i", isActive);
			List<ServerDetails> serverList = query.list();
			tx.commit();
			session.close();
			System.out.println("Server record returned for team and env and application :" + team +" and " +environment+" and " +application+" and " +isActive);
			return serverList;
			}catch(Exception e){
				System.out.println("Could not get server record");
				e.printStackTrace();
				return null;
				}
	}

	

	


}

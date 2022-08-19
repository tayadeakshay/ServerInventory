package com.pro.wings.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Entity
@Data
public class ServerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String iPAddress;
	
	String serverName;
	
	String serverType;
	
	int portNo;
	
	String CommissionDate;
	
	String isActive;
	
	String usageCapacity;
	
	String operatingSystem;
	
	String team;
	
	String environment;
	
	String application;
}

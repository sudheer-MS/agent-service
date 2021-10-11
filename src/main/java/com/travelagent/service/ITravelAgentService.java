package com.travelagent.service;

import java.util.List;

import com.travelagent.model.Priority;
import com.travelagent.model.Status;
import com.travelagent.model.TravelAgent;
import com.travelagent.model.TravelPackage;
/**
 * @author SudheerMS
 *
 */
public interface ITravelAgentService {
	
	TravelAgent createAgent(TravelAgent travelAgent);
	
	TravelAgent updateTravelAgent(TravelAgent travelAgent);
	
	String deleteTravelAgent(int agentId);
	
	TravelAgent getByAgentId(int agentId);
	
	List<TravelAgent> getAllAgents();
	
	List<TravelAgent> getAgentsByName(String agentName);
	
	List<TravelAgent> getAgentsByOwner(String owner);
	
	List<TravelAgent> getAgentsByPriority(Priority priority);
	
	List<TravelAgent> getAgentsByStatus(Status status);
	
	// methods calling from package service
	TravelPackage createTravelPackage(TravelPackage travelPackage, int agentId);
	
	String updateTravelPackage(TravelPackage travelPackage);
	
	String deleteTravelPackage(int packageId);
	
	TravelPackage getTravelPackageById(int packageId);
	
}

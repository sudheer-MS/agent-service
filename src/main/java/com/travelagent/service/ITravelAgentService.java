package com.travelagent.service;

import java.util.List;

import com.travelagent.model.TravelAgent;
/**
 * @author SudheerMS
 *
 */
public interface ITravelAgentService {
	
	TravelAgent createAgent(TravelAgent travelAgent);
	
	String updateTravelAgent(TravelAgent travelAgent);
	
	String deleteTravelAgent(int agentId);
	
	TravelAgent getByAgentId(int agentId);
	
	List<TravelAgent> getAllAgents();
	
	List<TravelAgent> getAgentsByName(String agentName);
	
	List<TravelAgent> getAgentsByOwner(String owner);
	
	List<TravelAgent> getAgentsByPriority(String priority);
	
	List<TravelAgent> getAgentsByStatus(String status);
	
}

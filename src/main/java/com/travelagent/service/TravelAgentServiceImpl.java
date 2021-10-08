package com.travelagent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.travelagent.model.TravelAgent;
import com.travelagent.repository.ITravelAgentRepository;
/**
 * @author SudheerMS
 *
 */
public class TravelAgentServiceImpl implements ITravelAgentService{
	
	ITravelAgentRepository travelAgentRepository;
	
	@Autowired
	public void setTravelAgentRepository(ITravelAgentRepository travelAgentRepository) {
		this.travelAgentRepository = travelAgentRepository;
	}

	@Override
	public TravelAgent createAgent(TravelAgent travelAgent) {
		TravelAgent newTravelAgent = travelAgentRepository.save(travelAgent);
		return newTravelAgent;
	}

	@Override
	public TravelAgent updateTravelAgent(TravelAgent travelAgent) {
		TravelAgent updatedAgent = travelAgentRepository.save(travelAgent);
		return updatedAgent;
	}

	@Override
	public String deleteTravelAgent(int agentId) {
		travelAgentRepository.deleteById(agentId);
		return "Travel agent deleted successfully";
	}

	@Override
	public TravelAgent getByAgentId(int agentId) {
		TravelAgent travelAgent = travelAgentRepository.findById(agentId).get();
		return travelAgent;
	}

	@Override
	public List<TravelAgent> getAllAgents() {
		List<TravelAgent> allAgents = travelAgentRepository.findAll();
		return allAgents;
	}

	@Override
	public List<TravelAgent> getAgentsByName(String agentName) {
		List<TravelAgent> agentsByName = travelAgentRepository.findByAgentName(agentName);
		return agentsByName;
	}

	@Override
	public List<TravelAgent> getAgentsByOwner(String owner) {
		List<TravelAgent> agentsByOwner = travelAgentRepository.findByOwner(owner);
		return agentsByOwner;
	}

	@Override
	public List<TravelAgent> getAgentsByPriority(String priority) {
		List<TravelAgent> agentsByPriority = travelAgentRepository.findByPriority(priority);
		return agentsByPriority;
	}

	@Override
	public List<TravelAgent> getAgentsByStatus(String status) {
		List<TravelAgent> agentsByStatus = travelAgentRepository.findByStatus(status);
		return agentsByStatus;
	}

}

package com.travelagent.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.travelagent.exceptions.TravelAgentNotFoundException;
import com.travelagent.exceptions.TravelPackageNotFoundException;
import com.travelagent.model.Priority;
import com.travelagent.model.Status;
import com.travelagent.model.Task;
import com.travelagent.model.TravelAgent;
import com.travelagent.model.TravelPackage;
import com.travelagent.repository.ITravelAgentRepository;

/**
 * @author SudheerMS
 *
 */
@Service
public class TravelAgentServiceImpl implements ITravelAgentService {

	private RestTemplate restTemplate;

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public static final String BASEURL = "http://localhost:8082/packages-api";

	ITravelAgentRepository travelAgentRepository;

	@Autowired
	public void setTravelAgentRepository(ITravelAgentRepository travelAgentRepository) {
		this.travelAgentRepository = travelAgentRepository;
	}

	Set<TravelPackage> packages = new HashSet<>();

	Set<Task> tasks = new HashSet<>();

	@Override
	public TravelAgent createAgent(TravelAgent travelAgent) {
		travelAgent.setTravelPackages(packages);
		travelAgent.setTasks(tasks);
		TravelAgent newTravelAgent = travelAgentRepository.save(travelAgent);
		return newTravelAgent;
	}

	@Override
	public TravelAgent updateTravelAgent(TravelAgent travelAgent) {
		TravelAgent updatedAgent = travelAgentRepository.save(travelAgent);
		return updatedAgent;
	}

	@Override
	public String deleteTravelAgent(int agentId) throws TravelAgentNotFoundException {
		if (travelAgentRepository.findById(agentId).get() == null) {
			throw new TravelAgentNotFoundException("Travel Agent not found with the given id..");
		}
		travelAgentRepository.deleteById(agentId);
		return "Travel agent deleted successfully";
	}

	@Override
	public TravelAgent getByAgentId(int agentId) throws TravelAgentNotFoundException {
		TravelAgent travelAgent = travelAgentRepository.findById(agentId).get();
		if (travelAgent == null) {
			throw new TravelAgentNotFoundException("Travel Agent not found with the given id..");
		}
		return travelAgent;
	}

	@Override
	public List<TravelAgent> getAllAgents() throws TravelAgentNotFoundException {
		List<TravelAgent> allAgents = travelAgentRepository.findAll();
		if (allAgents.isEmpty()) {
			throw new TravelAgentNotFoundException("No Travel Agents found please create a new Agent");
		}
		return allAgents;
	}

	@Override
	public List<TravelAgent> getAgentsByName(String agentName) throws TravelAgentNotFoundException {
		List<TravelAgent> agentsByName = travelAgentRepository.findByAgentName(agentName);
		if (agentsByName.isEmpty()) {
			throw new TravelAgentNotFoundException(
					"No Travel Agents found with the given name. Please enter a valid name");
		}
		return agentsByName;
	}

	@Override
	public List<TravelAgent> getAgentsByOwner(String owner) throws TravelAgentNotFoundException {
		List<TravelAgent> agentsByOwner = travelAgentRepository.findByOwner(owner);
		if (agentsByOwner.isEmpty()) {
			throw new TravelAgentNotFoundException(
					"No Travel Agents found with the given owner. Please enter a valid owner name");
		}
		return agentsByOwner;
	}

	@Override
	public List<TravelAgent> getAgentsByPriority(Priority priority) throws TravelAgentNotFoundException {
		List<TravelAgent> agentsByPriority = travelAgentRepository.findByPriority(priority);
		if (agentsByPriority.isEmpty()) {
			throw new TravelAgentNotFoundException("No Travel Agents found with the given Priority.");
		}
		return agentsByPriority;
	}

	@Override
	public List<TravelAgent> getAgentsByStatus(Status status) throws TravelAgentNotFoundException {
		List<TravelAgent> agentsByStatus = travelAgentRepository.findByStatus(status);
		if (agentsByStatus.isEmpty()) {
			throw new TravelAgentNotFoundException("No Travel Agents found with the given Status.");
		}
		return agentsByStatus;
	}

	@Override
	public TravelPackage createTravelPackage(TravelPackage travelPackage, int agentId)
			throws TravelAgentNotFoundException {
		TravelAgent getTravelAgent = travelAgentRepository.findById(agentId)
				.orElseThrow(() -> new TravelAgentNotFoundException("Travel Agent not found with the given id.."));

		travelPackage.setTravelAgent(getTravelAgent);
		String url = BASEURL + "/packages";
		ResponseEntity<TravelPackage> newTravelPackage = restTemplate.postForEntity(url, travelPackage,
				TravelPackage.class);
		return newTravelPackage.getBody();
	}

	@Override
	public String updateTravelPackage(TravelPackage travelPackage) {
		String url = BASEURL + "/packages";
		restTemplate.postForEntity(url, travelPackage, TravelPackage.class);
		return " travel packageupdated successfully";
	}

	@Override
	public String deleteTravelPackage(int packageId) throws TravelPackageNotFoundException {
		TravelPackage getTravelPackage = getTravelPackageById(packageId);
		if (getTravelPackage == null) {
			throw new TravelPackageNotFoundException("Travel Agent not found with the given id..");
		}
		String url = BASEURL + "/packages/" + packageId;
		restTemplate.delete(url, packageId);
		return "travel package deleted successfully";
	}

	@Override
	public TravelPackage getTravelPackageById(int packageId) throws TravelPackageNotFoundException {
		String url = BASEURL + "/packages/package-id/" + packageId;
		ResponseEntity<TravelPackage> travelPackage = restTemplate.getForEntity(url, TravelPackage.class);
		if (travelPackage.getBody() == null) {
			throw new TravelPackageNotFoundException("Travel Agent not found with the given id..");
		}
		return travelPackage.getBody();
	}

}

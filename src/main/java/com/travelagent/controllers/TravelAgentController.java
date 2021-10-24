package com.travelagent.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelagent.model.Priority;
import com.travelagent.model.Status;
import com.travelagent.model.Task;
import com.travelagent.model.TravelAgent;
import com.travelagent.model.TravelPackage;
import com.travelagent.service.ITravelAgentService;
/**
 * @author SudheerMS
 *
 */
@RestController
@RequestMapping("/agent-api")
public class TravelAgentController {
	
	ITravelAgentService travelAgentService;
	
	@Autowired
	public void setTravelAgentService(ITravelAgentService travelAgentService) {
		this.travelAgentService = travelAgentService;
	}
	
	Set<Task> tasks = new HashSet<>();

	@PostMapping("/agents")
	ResponseEntity<TravelAgent> createAgent(@RequestBody TravelAgent travelAgent){
		TravelAgent newTravelAgent = travelAgentService.createAgent(travelAgent);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "create a travel agent api");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(newTravelAgent);
	}
	
	@PutMapping("/agents")
	ResponseEntity<TravelAgent> updateTravelAgent(@RequestBody TravelAgent travelAgent){
		TravelAgent updatedAgent = travelAgentService.updateTravelAgent(travelAgent);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "update a travel agent api");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(updatedAgent);
	}
	
	@DeleteMapping("/agents/{agentId}")
	ResponseEntity<String> deleteTravelAgent(@PathVariable("agentId") int agentId){
		String reponse = travelAgentService.deleteTravelAgent(agentId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "delete a travel agent api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(reponse);
	}
	
	@GetMapping("/agents/{agentId}")
	ResponseEntity<TravelAgent> getByAgentId(@PathVariable("agentId") int agentId){
		TravelAgent getTravelAgent = travelAgentService.getByAgentId(agentId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get a travel agent by id api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(getTravelAgent);
	}
	
	@GetMapping("/agents")
	ResponseEntity<List<TravelAgent>> getAllAgents(){
		List<TravelAgent> allAgents = travelAgentService.getAllAgents();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get all travel agents api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(allAgents);
	}
	
	@GetMapping("/agents/agent-name/{agentName}")
	ResponseEntity<List<TravelAgent>> getAgentsByName(@PathVariable("agentName") String agentName){
		List<TravelAgent> agentsByName = travelAgentService.getAgentsByName(agentName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get travel agents by name api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(agentsByName);
	}
	
	@GetMapping("/agents/owner/{owner}")
	ResponseEntity<List<TravelAgent>> getAgentsByOwner(@PathVariable("owner") String owner){
		List<TravelAgent> agentsByOwner = travelAgentService.getAgentsByOwner(owner);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get travel agents by owner api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(agentsByOwner);
	}
	
	@GetMapping("/agents/priority/{priority}")
	ResponseEntity<List<TravelAgent>> getAgentsByPriority(@PathVariable("priority") String priority){
		Priority agentPriority = Priority.valueOf(priority.toUpperCase());
		List<TravelAgent> agentsByPriority = travelAgentService.getAgentsByPriority(agentPriority);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get travel agents by priority api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(agentsByPriority);
	}
	
	@GetMapping("/agents/status/{status}")
	ResponseEntity<List<TravelAgent>> getAgentsByStatus(@PathVariable("status") String status){
		Status agentStatus = Status.valueOf(status.toUpperCase());
		List<TravelAgent> agentsByStatus = travelAgentService.getAgentsByStatus(agentStatus);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get travel agents by status api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(agentsByStatus);
	}
	
	// rest template methods
	
	@PostMapping("/agents/travel-package/{agentId}")
	ResponseEntity<TravelPackage> createTravelPackage(@PathVariable("agentId") Integer agentId, @RequestBody TravelPackage travelPackage) {
		TravelPackage newTravelPackage = travelAgentService.createTravelPackage(travelPackage, agentId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "create travel package by agent - api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(newTravelPackage); 
	}
	
	@PutMapping("/agents/travel-package")
	ResponseEntity<String> updateTravelPackage(@RequestBody TravelPackage travelPackage) {
		String response = travelAgentService.updateTravelPackage(travelPackage);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "update travel package by agent - api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response);
	}
	
	@DeleteMapping("/agents/travel-package/{packageId}")
	ResponseEntity<String> deleteTravelPackage(@PathVariable("packageId") int packageId) {
		String response = travelAgentService.deleteTravelPackage(packageId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "delete travel package by agent - api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(response);
	}
	
	@GetMapping("/agents/travel-package/package-id/{packageId}")
	ResponseEntity<TravelPackage> getTravelPackageById(@PathVariable("packageId") int packageId) {
		TravelPackage newTravelPackage = travelAgentService.getTravelPackageById(packageId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get a travel package by Id from agent - api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(newTravelPackage);
	}
	
}

package com.travelagent.controllers;

import java.util.List;

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

import com.travelagent.model.TravelAgent;
import com.travelagent.service.ITravelAgentService;
/**
 * @author SudheerMS
 *
 */
@RestController
@RequestMapping("/agent-service")
public class TravelAgentController {
	
	ITravelAgentService travelAgentService;
	
	@PostMapping("/agent")
	ResponseEntity<TravelAgent> createAgent(@RequestBody TravelAgent travelAgent){
		TravelAgent newTravelAgent = travelAgentService.createAgent(travelAgent);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "create a travel agent api");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(newTravelAgent);
	}
	
	@PutMapping("/agent")
	ResponseEntity<String> updateTravelAgent(@RequestBody TravelAgent travelAgent){
		String reponse = travelAgentService.updateTravelAgent(travelAgent);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "update a travel agent api");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(reponse);
	}
	
	@DeleteMapping("/agent/{agentId}")
	ResponseEntity<String> deleteTravelAgent(@PathVariable("agentId") int agentId){
		String reponse = travelAgentService.deleteTravelAgent(agentId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "delete a travel agent api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(reponse);
	}
	
	@GetMapping("/agent/{agentId}")
	ResponseEntity<TravelAgent> getByAgentId(@PathVariable("agentId") int agentId){
		TravelAgent getTravelAgent = travelAgentService.getByAgentId(agentId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get a travel agent by id api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(getTravelAgent);
	}
	
	@GetMapping("/agent")
	ResponseEntity<List<TravelAgent>> getAllAgents(){
		List<TravelAgent> allAgents = travelAgentService.getAllAgents();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get all travel agents api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(allAgents);
	}
	
	@GetMapping("/agent/name/{name}")
	ResponseEntity<List<TravelAgent>> getAgentsByName(@PathVariable("name") String agentName){
		List<TravelAgent> agentsByName = travelAgentService.getAgentsByName(agentName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get travel agents by name api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(agentsByName);
	}
	
	@GetMapping("/agent/owner/{owner}")
	ResponseEntity<List<TravelAgent>> getAgentsByOwner(@PathVariable("owner") String owner){
		List<TravelAgent> agentsByOwner = travelAgentService.getAgentsByOwner(owner);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get travel agents by owner api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(agentsByOwner);
	}
	
	@GetMapping("/agent/priority/{priority}")
	ResponseEntity<List<TravelAgent>> getAgentsByPriority(@PathVariable("priority") String priority){
		List<TravelAgent> agentsByPriority = travelAgentService.getAgentsByPriority(priority);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get travel agents by priority api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(agentsByPriority);
	}
	
	@GetMapping("/agent/status/{status}")
	ResponseEntity<List<TravelAgent>> getAgentsByStatus(@PathVariable("status") String status){
		List<TravelAgent> agentsByStatus = travelAgentService.getAgentsByStatus(status);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get travel agents by status api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(agentsByStatus);
	}
	
}

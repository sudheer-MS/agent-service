package com.travelagent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelagent.model.TravelAgent;
/**
 * @author SudheerMS
 *
 */
@Repository
public interface ITravelAgentRepository extends JpaRepository<TravelAgent, Integer> {

	List<TravelAgent> findByAgentName(String agentName);
	
	List<TravelAgent> findByOwner(String owner);
	
	List<TravelAgent> findByPriority(String priority);
	
	List<TravelAgent> findByStatus(String status);
}

package com.travelagent.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * @author SudheerMS
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Task {
	@Id
	@GeneratedValue(generator = "task_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "task_gen", sequenceName = "task_seq", initialValue = 1, allocationSize = 1)
	private Integer taskId;
	private String taskName;
	private String category;
	private String owner;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private double duration;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "agent_id")
	@JsonIgnore
	private TravelAgent travelAgent;
	
	@ManyToOne
	@JoinColumn(name = "package_id")
	@JsonIgnore
	private TravelPackage travelPackage;
	
}

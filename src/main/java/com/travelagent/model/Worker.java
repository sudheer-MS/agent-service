package com.travelagent.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Worker {
	@Id
	@GeneratedValue(generator = "worker_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "worker_gen", sequenceName = "worker_seq", initialValue = 1, allocationSize = 1)
	private Integer workerId;
	private String workerName;
	@Enumerated(EnumType.STRING)
	private WorkerType type;
	@Enumerated(EnumType.STRING)
	private Availability availability;
	
	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;
}

package com.zerog.taskmanagement.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Requester extends Person {
	
	@JsonIgnore
	@ManyToMany(mappedBy="requesters")
	private List<Task> tasks;
	
}

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
public class Assignee extends Person {
	
	@JsonIgnore
	@ManyToMany(mappedBy="assignee")
	private List<Task> tasks;

}

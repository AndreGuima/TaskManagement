package com.zerog.taskmanagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Task {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id Long id;

	@NotNull
	private String summary;

	private String description;

	@ManyToMany
	@JoinTable(name = "task_assignee", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "assignee_id"))
	private List<Assignee> assignee;

	@ManyToMany
	@JoinTable(name = "task_requester", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "requester_id"))
	private List<Requester> requesters;

	@NotNull
	private Date createdDate;

	@NotNull
	private Date updatedDate;

}

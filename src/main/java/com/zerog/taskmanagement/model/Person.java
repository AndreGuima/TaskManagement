package com.zerog.taskmanagement.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.Data;

@MappedSuperclass
@Data
public class Person {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private @Id Long id;
	
	@NotNull
	@Column(unique=true)
	private String name;

}

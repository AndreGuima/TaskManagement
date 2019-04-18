package com.zerog.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerog.taskmanagement.model.Assignee;
import com.zerog.taskmanagement.service.AssigneeService;

@RestController
@RequestMapping("/assignees")
public class AssigneeController {

	@Autowired
	AssigneeService assigneeService;

	@GetMapping
	public List<Assignee> findAll() {
		return this.assigneeService.findAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.assigneeService.delete(id);
	}

}

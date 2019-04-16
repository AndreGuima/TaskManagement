package com.zerog.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerog.taskmanagement.model.Task;
import com.zerog.taskmanagement.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping
	public List<Task> findAll(){
		List<Task> list = this.taskService.findAll();
		return list;
	}
	
	@GetMapping("{id}")
	public Task findById(@PathVariable("id") Long id) {
		return this.taskService.findById(id);
	}
	
	@PostMapping
	public Task save(@RequestBody Task task) {
		return this.taskService.save(task);
	}
	
	@PutMapping("{id}")
	public Task update(@PathVariable("id") Long id, @RequestBody Task task) {
		return this.taskService.update(id, task);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		Task task = taskService.findById(id);
		this.taskService.delete(task);
	}

}

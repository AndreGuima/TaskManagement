package com.zerog.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerog.taskmanagement.model.Requester;
import com.zerog.taskmanagement.service.RequesterService;

@RestController
@RequestMapping("/requesters")
public class RequesterController {

	@Autowired
	RequesterService requesterService;

	@GetMapping
	public List<Requester> findAll() {
		return this.requesterService.findAll();
	}
	
	@DeleteMapping("/{id}")	
	public void delete(@PathVariable("id") Long id) {
		this.requesterService.delete(id);
	}

}

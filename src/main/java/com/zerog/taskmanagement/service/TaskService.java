package com.zerog.taskmanagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerog.taskmanagement.exception.TaskNotFoundException;
import com.zerog.taskmanagement.model.Task;
import com.zerog.taskmanagement.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	AssigneeService assigneeService;

	@Autowired
	RequesterService requesterService;

	public List<Task> findAll() {
		return this.taskRepository.findAll();
	}

	public Task findById(Long id) {
		return this.taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found " + id));
	}

	public Task save(Task task) {
		task.setRequesters(requesterService.findByIdOrSave(task.getRequesters()));
		task.setAssignee(assigneeService.findByIdOrSave(task.getAssignee()));
		
		task.setCreatedDate(new Date());
		task.setUpdatedDate(new Date());
		
		return taskRepository.saveAndFlush(task);
	}

	public Task update(Long id, Task updatedTask) {
		Task task = this.taskRepository.findById(id).orElseThrow(null);
		task.setSummary(updatedTask.getSummary());
		task.setDescription(updatedTask.getDescription());
		task.setAssignee(updatedTask.getAssignee());
		task.setRequesters(updatedTask.getRequesters());
		
		task.setCreatedDate(updatedTask.getCreatedDate());
		task.setUpdatedDate(updatedTask.getUpdatedDate());
		
		this.taskRepository.flush();
		return task;
	}

	public void delete(Task task) {
		this.taskRepository.delete(task);
	}

}

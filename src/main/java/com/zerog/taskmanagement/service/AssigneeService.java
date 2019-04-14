package com.zerog.taskmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerog.taskmanagement.model.Assignee;
import com.zerog.taskmanagement.repository.AssigneeRepository;

@Service
public class AssigneeService {
	
	@Autowired
	AssigneeRepository assigneeRepository;
	
	public Assignee findById(Long id) {
		return this.assigneeRepository.findById(id).orElseThrow(null);
	}
	
	public Assignee save(Assignee assignee) {
		return this.assigneeRepository.save(assignee);
	}

	public List<Assignee> findByIdOrSave(List<Assignee> assignees) {
		List<Assignee> returnAssignee = new ArrayList<Assignee>();
		assignees.forEach(assignee->{
			if(this.findById(assignee.getId()) != null) {
				returnAssignee.add(this.findById(assignee.getId()));
			}else {
				returnAssignee.add(this.save(assignee));
			}
		});
		return returnAssignee;
	}
		
}

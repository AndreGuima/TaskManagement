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
			try {
				if(assignee.getId() == null) {
					Assignee newAssignee = new Assignee();
					newAssignee.setName(assignee.getName());
					returnAssignee.add(this.assigneeRepository.saveAndFlush(newAssignee));
				}else if(this.findById(assignee.getId()) instanceof Assignee) {
					returnAssignee.add(this.findById(assignee.getId()));
				}else if(assignee instanceof Assignee) {
					returnAssignee.add(this.save(assignee));
				}
			} catch (Exception e) {
				throw(e);
			}
		});
		return returnAssignee;
	}
		
}

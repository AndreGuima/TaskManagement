package com.zerog.taskmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerog.taskmanagement.model.Requester;
import com.zerog.taskmanagement.repository.RequesterRepository;

@Service
public class RequesterService {
	
	@Autowired
	RequesterRepository requesterRepository;
	
	public Requester findById(Long id) {
		return this.requesterRepository.findById(id).orElseThrow(null);
	}
	
	public Requester save(Requester requester) {
		return this.requesterRepository.save(requester);
	}

	public List<Requester> findByIdOrSave(List<Requester> requesters) {
		List<Requester> returnRequester = new ArrayList<Requester>();
		requesters.forEach(requester->{
			try {
				if(requester.getId() == null) {
					Requester newRequester = new Requester();
					newRequester.setName(requester.getName());
					returnRequester.add(this.requesterRepository.saveAndFlush(newRequester));
				}else if(this.findById(requester.getId()) instanceof Requester) {
					returnRequester.add(this.findById(requester.getId()));
				}else if(requester instanceof Requester) {
					returnRequester.add(this.save(requester));
				}
			} catch (Exception e) {
				throw(e);
			}
		});
		return returnRequester;
	}
		
}

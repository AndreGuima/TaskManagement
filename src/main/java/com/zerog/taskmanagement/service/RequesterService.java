package com.zerog.taskmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerog.taskmanagement.exception.RequesterNotFoundException;
import com.zerog.taskmanagement.model.Requester;
import com.zerog.taskmanagement.repository.RequesterRepository;

@Service
public class RequesterService {

	@Autowired
	RequesterRepository requesterRepository;

	public List<Requester> findAll() {
		return this.requesterRepository.findAll();
	}

	public Requester findById(Long id) {
		return this.requesterRepository.findById(id)
				.orElseThrow(() -> new RequesterNotFoundException("Requester not found " + id));
	}

	public Requester save(Requester requester) {
		return this.requesterRepository.save(requester);
	}

	public List<Requester> findByIdOrSave(List<Requester> requesters) {

		List<Requester> taskRequesters = new ArrayList<Requester>();
		for (Requester requester : requesters) {
			if (requester.getId() != null) {
				Requester existentRequester = this.findById(requester.getId());
				taskRequesters.add(existentRequester);
			} else {
				Requester newRequester = new Requester();
				newRequester.setName(requester.getName());
				taskRequesters.add(this.requesterRepository.saveAndFlush(newRequester));
			}
		}

		return taskRequesters;
	}

	public void delete(Long id) {
		Requester requester = this.findById(id);
		if (requester != null) {
			this.requesterRepository.delete(requester);
		} else {
			throw new RequesterNotFoundException("Requester not found " + id);
		}
	}

}

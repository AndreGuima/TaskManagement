package com.zerog.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zerog.taskmanagement.model.Requester;

@Repository
public interface RequesterRepository extends JpaRepository<Requester, Long> {

	Requester findByName(String name);

}

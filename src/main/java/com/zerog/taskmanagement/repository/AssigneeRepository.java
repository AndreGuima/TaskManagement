package com.zerog.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zerog.taskmanagement.model.Assignee;

@Repository
public interface AssigneeRepository extends JpaRepository<Assignee, Long> {

}

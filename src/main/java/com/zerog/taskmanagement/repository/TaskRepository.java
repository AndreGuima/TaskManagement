package com.zerog.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zerog.taskmanagement.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}

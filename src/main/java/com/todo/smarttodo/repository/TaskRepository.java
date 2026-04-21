package com.todo.smarttodo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.smarttodo.entity.Priority;
import com.todo.smarttodo.entity.Status;
import com.todo.smarttodo.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	List<Task> findByPriority(Priority priority);
	
	List<Task> findByStatus(Status status);
}

package com.todo.smarttodo.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.todo.smarttodo.entity.Priority;
import com.todo.smarttodo.entity.Status;
import com.todo.smarttodo.entity.Task;

public interface TaskService {
	Task createTask(Task task);
	
	List<Task> getAllTasks();
	
	Task updateTask(Long id, Task task);
	
	void deleteTask(Long id);
	
	//from here filtering
	List<Task> getTaskByPriority(Priority priority);
	
	List<Task> getTaskByStatus(Status status);
	
	//from here, for pagination
	Page<Task> getPagedTasks(Pageable pageable);
}

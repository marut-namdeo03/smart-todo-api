package com.todo.smarttodo.service;


import java.util.List;

import com.todo.smarttodo.entity.Priority;
import com.todo.smarttodo.entity.Status;
import com.todo.smarttodo.entity.Task;

public interface TaskService {
	Task createTask(Task task);
	
	List<Task> getAllTasks();
	
	Task updateTask(Long id, Task task);
	
	void deleteTask(Long id);
	
	List<Task> getTaskByPriority(Priority priority);
	
	List<Task> getTaskByStatus(Status status);
}

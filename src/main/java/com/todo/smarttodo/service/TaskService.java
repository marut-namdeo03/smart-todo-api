package com.todo.smarttodo.service;


import java.util.List;

import com.todo.smarttodo.entity.Task;

public interface TaskService {
	Task createTask(Task task);
	
	List<Task> getAllTasks();
}

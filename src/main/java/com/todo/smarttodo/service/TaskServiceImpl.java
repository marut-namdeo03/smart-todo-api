package com.todo.smarttodo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.smarttodo.entity.Task;
import com.todo.smarttodo.repository.TaskRepository;

import com.todo.smarttodo.entity.Status;

@Service
public class TaskServiceImpl implements TaskService {
	
	private final TaskRepository taskRepository;
	
	public TaskServiceImpl (TaskRepository taskRepository)
	{
		this.taskRepository = taskRepository;
	}
	
	@Override
	public Task createTask(Task task)
	{
		//default status
		task.setStatus(Status.PENDING);
		
		return taskRepository.save(task);
	}
	
	@Override
	public List<Task> getAllTasks()
	{
		return taskRepository.findAll();
	}
}

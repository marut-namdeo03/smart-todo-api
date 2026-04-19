package com.todo.smarttodo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.smarttodo.entity.Task;
import com.todo.smarttodo.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	private final TaskService taskService;
	
	public TaskController(TaskService taskService)
	{
		this.taskService = taskService;
	}
	
	//create API - Add Task
	@PostMapping
	public Task createTask(@RequestBody Task task)
	{
		return taskService.createTask(task);
	}
	
	//create API - get all tasks
	@GetMapping
	public List<Task> getAllTasks()
	{
		return taskService.getAllTasks();
	}
	
}

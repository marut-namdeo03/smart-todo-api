package com.todo.smarttodo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//create API - update task
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task task)
	{
		return taskService.updateTask(id, task);
	}
	
	//create API - delete task
	@DeleteMapping("/{id}")
	public String deleteTask(@PathVariable Long id)
	{
		taskService.deleteTask(id);
		return "Task deleted successfully";
	}
}

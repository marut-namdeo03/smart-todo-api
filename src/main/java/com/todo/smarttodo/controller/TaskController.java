package com.todo.smarttodo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.smarttodo.entity.Priority;
import com.todo.smarttodo.entity.Status;
import com.todo.smarttodo.entity.Task;
import com.todo.smarttodo.service.TaskService;

@RestController //build REST API & return JSON/XML
@RequestMapping("/tasks") //maps HTTP requests to controller methods
public class TaskController {
	
	private final TaskService taskService;
	
	public TaskController(TaskService taskService)
	{
		this.taskService = taskService;
	}
	
	//create data(API) - Add Task
	@PostMapping //handles HTTP POST request
	public Task createTask(@RequestBody Task task)
	{
		return taskService.createTask(task);
	}
	//create API (for read data) - get task by id
	@GetMapping("/{id}")  //handles HTTP GET request
	public Task getTaskById(@PathVariable Long id) {
	    return taskService.getTaskById(id);
	}
	
	//create API (for update data) - update task
	@PutMapping("/{id}") //handles HTTP PUT request
	public Task updateTask(@PathVariable Long id, @RequestBody Task task)
	{
		return taskService.updateTask(id, task);
	}
	
	//create API - delete task
	@DeleteMapping("/{id}")  //handles HTTP request
	public String deleteTask(@PathVariable Long id)
	{
		taskService.deleteTask(id);
		return "Task deleted successfully";
	}
	
	//from here, used filtering
	//create API - find tasks by priority
	@GetMapping("/priority/{priority}")
	public List<Task> getByPriority(@PathVariable Priority priority)
	{
		return taskService.getTaskByPriority(priority);
	}
	
	@GetMapping("/status/{status}")
	public List<Task> getByStatus(@PathVariable Status status)
	{
		return taskService.getTaskByStatus(status);
	}
	
	//from here, for pagination
	
	@GetMapping
	public Page<Task> getPagedTasks(Pageable pageable)
	{
		return taskService.getPagedTasks(pageable);
	}
}

package com.todo.smarttodo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.smarttodo.entity.Task;
import com.todo.smarttodo.repository.TaskRepository;
import com.todo.smarttodo.entity.Priority;
import com.todo.smarttodo.entity.Status;

@Service
public class TaskServiceImpl implements TaskService {
	
	private final TaskRepository taskRepository;
	
	public TaskServiceImpl (TaskRepository taskRepository)
	{
		this.taskRepository = taskRepository;
	}
	
	@Override  //for create new task
	public Task createTask(Task task)
	{
		//default status
		task.setStatus(Status.PENDING);
		
		return taskRepository.save(task);
	}
	
	@Override  //for get all tasks
	public List<Task> getAllTasks()
	{
		return taskRepository.findAll();
	}
	
	@Override  //for update task
	public Task updateTask(Long id, Task updatedTask)
	{
		Task existingTask = taskRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Task not found"));
		
		existingTask.setTitle(updatedTask.getTitle());
		existingTask.setDescription(updatedTask.getDescription());;
		existingTask.setPriority(updatedTask.getPriority());
		existingTask.setDueDate(updatedTask.getDueDate());
		
		return taskRepository.save(existingTask);
	}
	
	@Override  //for delete task
	public void deleteTask(Long id)
	{
		taskRepository.deleteById(id);
	}
	
	@Override
	public List<Task> getTaskByPriority(Priority priority)
	{
		return taskRepository.findByPriority(priority);
	}
	
	@Override 
	public List<Task> getTaskByStatus(Status status)
	{
		return taskRepository.findByStatus(status);
	}
}

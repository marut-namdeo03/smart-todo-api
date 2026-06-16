package com.todo.smarttodo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.todo.smarttodo.entity.Task;
import com.todo.smarttodo.exception.ResourceNotFoundException;
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
		//task.setStatus(Status.PENDING);
		
		//for auto Overdue logic
		if(task.getDueDate() != null && task.getDueDate().isBefore(LocalDate.now()))
		{	
			task.setStatus(Status.OVERDUE);
		} else {
			task.setStatus(Status.PENDING);
		}
		
		
		return taskRepository.save(task);
	}
	
	@Override  //for get task by id
	public Task getTaskById(Long id) {
	    return taskRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
	}
	
	@Override  //for update task
	public Task updateTask(Long id, Task updatedTask)
	{
		Task existingTask = taskRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Task not found"));
		
		existingTask.setTitle(updatedTask.getTitle());
		existingTask.setDescription(updatedTask.getDescription());;
		existingTask.setPriority(updatedTask.getPriority());
		existingTask.setDueDate(updatedTask.getDueDate());
		
		//smart logic
		if (existingTask.getDueDate() != null && existingTask.getDueDate().isBefore(LocalDate.now()) && existingTask.getStatus() != Status.COMPLETED)
		{
			existingTask.setStatus(Status.OVERDUE);
		} else {
			existingTask.setStatus(Status.PENDING);
		}
		return taskRepository.save(existingTask);
	}
	
	@Override  //for delete task
	public void deleteTask(Long id)
	{
		taskRepository.deleteById(id);
	}
	
	//from here, for filtering
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
	
	//from here, for pagination
	@Override
	public Page<Task> getPagedTasks(Pageable pageable)
	{
		Page<Task> taskPage = taskRepository.findAll(pageable);
		
		taskPage.getContent().forEach(task -> {
	        if (task.getDueDate() != null &&
	            task.getDueDate().isBefore(LocalDate.now()) &&
	            task.getStatus() != Status.COMPLETED) {

	            task.setStatus(Status.OVERDUE);
	        } else if (task.getStatus() != Status.COMPLETED)
	        {
	        	task.setStatus(Status.PENDING);
	        }
	});
		return taskPage;
}
}

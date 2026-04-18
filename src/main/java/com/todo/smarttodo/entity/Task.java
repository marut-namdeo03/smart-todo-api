package com.todo.smarttodo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

//for lombok
/*
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
*/

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	private LocalDate dueDate;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	//setters
	public void setStatus(Status status)
	{
		this.status = status;
	}
	
	//getters
	public Status getStatus()
	{
		return status;
	}
	
	//No-args constructor
	public Task()
	{
	}
	
	//All-args constructor
	public Task(Long id, String title, String description, Priority priority,
			LocalDate dueDate, Status status)
	{
		this.id = id;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.dueDate = dueDate;
		this.status = status;
	}
	
}

package com.todo.smarttodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.smarttodo.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}

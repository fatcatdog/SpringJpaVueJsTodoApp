package com.fatcatdog.todo.repository;

import org.springframework.data.repository.CrudRepository;

import com.fatcatdog.todo.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}

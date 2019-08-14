package com.fatcatdog.todo.repository;

import org.springframework.data.repository.CrudRepository;

import com.fatcatdog.todo.model.Task;

//this class uses Spring JPA's CrudRepository to bring in all of our methods/functionality. 
//This class is used by our taskservice class
public interface TaskRepository extends CrudRepository<Task, Integer> {

}

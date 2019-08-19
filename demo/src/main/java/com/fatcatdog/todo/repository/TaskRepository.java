package com.fatcatdog.todo.repository;

import java.util.Optional;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fatcatdog.todo.model.Task;

//this class uses Spring JPA's CrudRepository to bring in all of our methods/functionality. 
//This class is used by our taskservice class
public interface TaskRepository extends CrudRepository<Task, Integer> {

	//this is a custom JPA query to fetch tasks by code
	Optional<Task> findByCode(int code);
	
	@Query("SELECT MAX(t.code) FROM Task t")
    Optional<Integer> findMaxCode();

}

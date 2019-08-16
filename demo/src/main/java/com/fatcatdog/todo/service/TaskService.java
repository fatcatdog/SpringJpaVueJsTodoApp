package com.fatcatdog.todo.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatcatdog.todo.controller.TaskController;
import com.fatcatdog.todo.model.Task;
import com.fatcatdog.todo.repository.TaskRepository;

//@Service  brings in appropriate beans
//This class brings in an instance of our TaskRepository to add more abstraction user from DB
@Service
public class TaskService {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

	@Autowired
	private TaskRepository taskRepository;
	
	public Iterable<Task> getAllTasks(){

	    logger.info("TaskService getAllTasks");
		return taskRepository.findAll();
	}
	
	public void save(Task task) {

	    logger.info("TaskService save");
	    logger.info("Task: " + task);
		taskRepository.save(task);
	}
	
	public void delete(Task task) {
		logger.info("TaskService delete");
	    logger.info("Task: " + task);
		taskRepository.delete(task);
	}
	
	public Optional<Task> getTask(int id) {
		logger.info("TaskService getTask");
	    logger.info("Task id: " + id);
	    return taskRepository.findById(id);
	}
	
}

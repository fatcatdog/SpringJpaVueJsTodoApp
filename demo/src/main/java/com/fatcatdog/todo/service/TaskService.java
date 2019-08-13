package com.fatcatdog.todo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatcatdog.todo.model.Task;
import com.fatcatdog.todo.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public Iterable<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	public void save(Task task) {
		taskRepository.save(task);
	}
	
	public void delete(Task task) {
		taskRepository.delete(task);
	}
	
	public Optional<Task> getTask(int id) {
		return taskRepository.findById(id);
	}
	
}

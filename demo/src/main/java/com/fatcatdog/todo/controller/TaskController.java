package com.fatcatdog.todo.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatcatdog.todo.DemoApplication;
import com.fatcatdog.todo.model.Task;
import com.fatcatdog.todo.service.TaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//this is the controller for application. API annotation is for Swagger configuration, 
//controller brings in appropriate java beans, request mapping preludes all endpoints with "api"

@Api(value="Task REST API ")
@Controller   
@RequestMapping(path="/api") 
public class TaskController {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	private TaskService taskService;

	@ApiOperation(value = "Add a task")
    @CrossOrigin(origins = "*")
	@PostMapping(path="/add", produces = "application/json; charset=UTF-8") 
	public ResponseEntity<?> addNewTask (@RequestBody Task task) {

		try {
			taskService.save(task);
		    logger.info("TaskController - addNewTask: " + task);
			return new ResponseEntity<>(HttpStatus.OK) ;
		} catch (Exception e) {
		    logger.error("TaskController - addNewTask: " + e);
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
	}
	
	@ApiOperation(value = "Update a task")
    @CrossOrigin(origins = "*")
	@PutMapping(path="/update",  produces = "application/json; charset=UTF-8") 
	public ResponseEntity<?> updateTask (@RequestBody Task task) {
			        
		try {
			taskService.save(task);
		    logger.info("TaskController - updateTask: " + task);
			return new ResponseEntity<>(HttpStatus.OK) ;
		} catch (Exception e) {
		    logger.error("TaskController - updateTask: " + e);			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;
		}
	}
	
	@ApiOperation(value = "Get all tasks")
    @CrossOrigin(origins = "*")
	@GetMapping(path = "/tasks",  produces = "application/json; charset=UTF-8") 
	public ResponseEntity<?> getAllTasks() {
		try {
    		Iterable<Task> tempTasks = taskService.getAllTasks();
		    logger.info("TaskController - getAllTasks: " + tempTasks);
    		return new ResponseEntity<>(tempTasks, HttpStatus.OK); 
		} catch (Exception e) {
			System.out.println(e);
		    logger.error("TaskController - getAllTasks: " + e);
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
	}
    
	@ApiOperation(value = "Get a task by Task id(int)")
    @CrossOrigin(origins = "*")
	@GetMapping(path = "/get/{id}",  produces = "application/json; charset=UTF-8") 
	public ResponseEntity<?> getTaskById(@PathVariable(name = "id") int id) {
		try {
    		Optional<Task> tempTask = taskService.getTask((id));
		    logger.info("TaskController - getTaskById: " + " id: " + id  + " task: " + tempTask);
    		return new ResponseEntity<>(tempTask, HttpStatus.OK); 
		} catch (Exception e) {
		    logger.error("TaskController - getTaskById: " + e);
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
	}
    
	@ApiOperation(value = "Delete a task")
    @CrossOrigin(origins = "*")
   	@DeleteMapping(path="/delete", produces = "application/json; charset=UTF-8") 
   	public ResponseEntity<?> deleteTask (@RequestBody Task task) {

		try {
   			taskService.delete(task);
		    logger.info("TaskController - deleteTask: " + task);
    		return new ResponseEntity<>(HttpStatus.OK); 
   		} catch (Exception e) {
		    logger.error("TaskController - deleteTask: " + e);
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
   		}
   	}
	
    
	@ApiOperation(value = "Fetch a task by code")
    @CrossOrigin(origins = "*")
   	@GetMapping(path="/code/{code}", produces = "application/json; charset=UTF-8") 
   	public ResponseEntity<?> getTaskByCode (@PathVariable(name = "code") int code) {

		try {
			Optional<Task> tempTask = taskService.getTaskByCode(code);
		    logger.info("TaskController - getTaskByCode: " + code);
    		return new ResponseEntity<>(tempTask, HttpStatus.OK); 
   		} catch (Exception e) {
		    logger.error("TaskController - getTaskByCode: " + code);
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
   		}
   	}
	
	@ApiOperation(value = "Fetch max task code")
    @CrossOrigin(origins = "*")
   	@GetMapping(path="/getMaxCode", produces = "application/json; charset=UTF-8") 
   	public ResponseEntity<?> getMaxCode () {

		try {
			Optional<Integer> tempNumber = taskService.findMaxCode();
		    logger.info("TaskController - getMaxCode: ");
    		return new ResponseEntity<>(tempNumber, HttpStatus.OK); 
   		} catch (Exception e) {
		    logger.error("TaskController - getMaxCode: ");
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
   		}
   	}
	
}

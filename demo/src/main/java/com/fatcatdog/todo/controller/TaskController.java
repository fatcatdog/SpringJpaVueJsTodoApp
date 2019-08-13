package com.fatcatdog.todo.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fatcatdog.todo.model.Task;
import com.fatcatdog.todo.service.TaskService;

@Controller   
@RequestMapping(path="/api") 
public class TaskController {

	@Autowired
	private TaskService taskService;

    @CrossOrigin(origins = "http://localhost:8080")
	@PostMapping(path="/add") 
	public @ResponseBody String addNewTask (@RequestBody Task task) {
		try {
			taskService.save(task);
			return "Saved";
		} catch (Exception e) {
			System.out.println(e);
			return "Not saved :(";
		}
	}
	
    @CrossOrigin(origins = "http://localhost:8080")
	@PutMapping(path="/update") 
	public @ResponseBody String updateTask (@RequestBody Task task) {
		try {
			taskService.save(task);
			return "Updated";
		} catch (Exception e) {
			System.out.println(e);
			return "Not saved :(";
		}
	}
	
    @CrossOrigin(origins = "http://localhost:8080")
	@GetMapping() 
	public ResponseEntity<?> getAllTasks() {
		try {
    		Iterable<Task> tempTasks = taskService.getAllTasks();
    		return new ResponseEntity<>(tempTasks, HttpStatus.OK); 
		} catch (Exception e) {
			System.out.println(e);
    		return new ResponseEntity<>("We Failed You", HttpStatus.BAD_REQUEST); 
		}
	}
    
    @CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(path = "/get/{id}") 
	public ResponseEntity<?> getTaskById(@PathVariable(name = "id") int id) {
		try {
    		Optional<Task> tempTask = taskService.getTask((id));
    		return new ResponseEntity<>(tempTask, HttpStatus.OK); 
		} catch (Exception e) {
			System.out.println(e);
    		return new ResponseEntity<>("We Failed You", HttpStatus.BAD_REQUEST); 
		}
	}
    
    @CrossOrigin(origins = "http://localhost:8080")
   	@DeleteMapping(path="/delete") 
   	public @ResponseBody String deleteTask (@RequestBody Task task) {
   		try {
   			taskService.delete(task);
   			return "Deleted";
   		} catch (Exception e) {
   			System.out.println(e);
   			return "Not deleted :(";
   		}
   	}
	
	
}

package com.fatcatdog.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.fatcatdog.todo.model.Task;
import com.fatcatdog.todo.service.TaskService;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private TaskService taskService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date();
		
		taskService.save(new Task("first task", "first description", date, false));
		taskService.save(new Task("second task", "second description", date, false));
	}

}
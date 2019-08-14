package com.fatcatdog.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.fatcatdog.todo.model.Task;
import com.fatcatdog.todo.service.TaskService;

//This class inputs 3 objects into the database upon booting up the application. 
//I set spring.jpa.hibernate.ddl-auto=create-drop in Application.properties, so the 
//database is dropped every time the application is stopped/started. 
@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private TaskService taskService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date oldDate = format.parse("2009-12-31");

		taskService.save(new Task("first task", "first description", date, false));
		taskService.save(new Task("second task", "second description", date, false));
		taskService.save(new Task("third task", "third description third description third description third description", oldDate, false));

	}

}
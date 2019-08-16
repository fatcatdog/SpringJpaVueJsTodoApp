//package com.fatcatdog.todo;
//
//import java.util.Date;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import com.fatcatdog.todo.model.Task;
//import com.fatcatdog.todo.service.TaskService;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@ContextConfiguration
//@PropertySource("applicationtest.properties")
//public class DemoApplicationTests {
//
//    @Autowired
//    TaskService repo;
//
//    @Test
//    public void myEmptySaveTest() throws Exception {
//		Task task = new Task();
//    	repo.save(task);
//    	Iterable<Task> tasks = repo.getAllTasks();
//
//    	assertThat(tasks).hasSize(0);
//    }
//    
//    @Test
//    public void myNotEmptySaveTest() throws Exception {
//		Date date = new Date();
//		Task task = new Task(484827, "name", "description", date, false);
//    	repo.save(task);
//    	Iterable<Task> tasks = repo.getAllTasks();
//    	
//    	assertThat(tasks).hasSize(1);
//    }
//
//    @Test
//    public void myEmptyUpdateTest() throws Exception {   
//    	
//    	repo.save(new Task());
//    	
//    	Iterable<Task> tasks = repo.getAllTasks();
//    	
//    	assertThat(tasks).hasSize(0);
//    }
//
//    @Test
//    public void myNotEmptyUpdateTest() throws Exception {
//    	Date date = new Date();
//		Task task = new Task(484827, "name", "description", date, true);
//    	repo.save(task);
//    	
//    	task.setDescription("different description");
//    	
//    	repo.save(task);
//
//
//    	Iterable<Task> tasks = repo.getAllTasks();
//    	
//    	assertThat(tasks).hasSize(1);
//    }
//    
//    
//    @Test
//    public void myDeleteTest() throws Exception {
//    	Date date = new Date();
//		Task task = new Task(484827, "name", "description", date, true);
//    	repo.save(task);
//    	
//    	repo.delete(task);
//    	
//    	Iterable<Task> tasks = repo.getAllTasks();
//    	
//    	assertThat(tasks).hasSize(0);
//    }
//    
//    @Test
//    public void myEmptyDeleteTest() throws Exception {
//    	Date date = new Date();
//
//    	Task task = new Task(484827, "name", "description", date, true);
//    	repo.save(task);
//    	
//    	repo.delete(new Task());
//    	
//    	Iterable<Task> tasks = repo.getAllTasks();
//    	
//    	assertThat(tasks).hasSize(1);
//    }
//
//}

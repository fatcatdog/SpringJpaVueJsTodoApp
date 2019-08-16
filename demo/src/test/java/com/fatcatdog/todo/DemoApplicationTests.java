package com.fatcatdog.todo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Optional;



import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fatcatdog.todo.model.Task;
import com.fatcatdog.todo.repository.TaskRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

////	Date date = new Date();
////
////	Task expected = Mockito.mock(Task.class);
////	expected.setName("test name");
////	expected.setDescription("test description");
////	expected.setDueDate(date);
////	expected.setStatus(true);
//	
//	@Autowired
//    private TestEntityManager entityManager;
// 
//    @Autowired
//    private TaskRepository taskRepo;
//	
//    @Test
//    public void whenFindByIdToReturnId() {
//    	Date date = new Date();
//
//        Task task = new Task();
//        task.setId(19484);
//        task.setName("test name");
//        task.setDescription("test description");
//        task.setDueDate(date);
//        task.setStatus(true);
//        
//        entityManager.persist(task);
//        entityManager.flush();
//     
//        // when
//        
//        Task found = taskRepo.findById(19484)
//                .orElse(new Task());
//
//        // then
//        assertThat(found.getName())
//          .isEqualTo(task.getName());
//    }


}

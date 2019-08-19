package com.fatcatdog.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fatcatdog.todo.controller.TaskController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationIntegrationTests {

	@Autowired
    private MockMvc mockMvc;

	@Autowired
    private TaskController controller;
	
	@Test
	public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
	}
	
    @Test
    public void checkIfControllerReturnsOkAtRoutes() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
        this.mockMvc.perform(get("/get/12343")).andDo(print()).andExpect(status().isNotFound());
        this.mockMvc.perform(get("/add")).andDo(print()).andExpect(status().isNotFound());
        this.mockMvc.perform(get("/delete")).andDo(print()).andExpect(status().isNotFound());
        this.mockMvc.perform(get("/update")).andDo(print()).andExpect(status().isNotFound());
        this.mockMvc.perform(get("/delete")).andDo(print()).andExpect(status().isNotFound());
        this.mockMvc.perform(get("/getMaxCode")).andDo(print()).andExpect(status().isNotFound());
    }
    
}

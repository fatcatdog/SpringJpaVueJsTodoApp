package com.fatcatdog.todo;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//entry point for the application
@SpringBootApplication
public class DemoApplication {
	  
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

package com.fatcatdog.todo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String description; 
	
	private Date dueDate;

	private Integer stage;

	public Task(Integer id, String name, String description, Date dueDate, Integer stage) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.stage = stage;
	}
	
	public Task(String name, String description, Date dueDate, Integer stage) {
		super();
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.stage = stage;
	}
	
	public Task() {super();}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Integer getStage() {
		return stage;
	}

	public void setStage(Integer stage) {
		this.stage = stage;
	} 
	
	
	
	

}

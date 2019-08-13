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
	
	private boolean status;

	public Task(Integer id, String name, String description, Date dueDate, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
	}
	
	public Task(String name, String description, Date dueDate, boolean status) {
		super();
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}

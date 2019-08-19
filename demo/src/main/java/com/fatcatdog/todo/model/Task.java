package com.fatcatdog.todo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

//Entity is used by Spring JPA to generate a table for Task in DB

@Entity
@Table(name = "task")
public class Task {
	
    @JsonProperty
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
	private Integer id;
	
    @JsonProperty
    @NotNull
    @Column(name = "name")
	private String name;
	
    @JsonProperty
    @NotNull
    @Column(name = "description")
	private String description; 
	
    @JsonProperty
    @NotNull
    @Column(name = "due_date")
	private Date dueDate;
    
    @JsonProperty
    @NotNull
    @Column(name = "code", unique=true)
	private int code;

    @JsonProperty
    @NotNull
    @Column(name = "status")
	private boolean status;

    
	public Task(Integer id, String name, String description, Date dueDate, int code, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.code = code;
		this.status = status;
	}
	
	public Task(String name, String description, Date dueDate, int code, boolean status) {
		super();
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.code = code;
		this.status = status;
	}
	
	public Task(String name, String description, Date dueDate, int code) {
		super();
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.code = code;
		this.status = false;
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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", dueDate=" + dueDate + ", code="
				+ code + ", status=" + status + "]";
	}
	

}

package com.example.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Name")
	private String name;

	@Column(name = "Salary")
	private String salary;
	
	@Column(name = "Department")
	private String department;
	
	public Employee1() {
		
	}

	public Employee1(long id, String name, String salary, String department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee1 [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}
	
	
	
	
	
	
	
	
}
package com;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

//annotations
//@Entity
//@Table(name="Employee")
public class Employee {
//	@Id
	private int id;
	private String name;
	private int age;
	private String desig;
	private int salary;
	public Employee() {
	}
	public Employee(int id, String name, int age, String desig) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.desig = desig;
		this.salary=salary;		
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}
	
	

}

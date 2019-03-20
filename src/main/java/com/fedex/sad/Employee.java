package com.fedex.sad;

public class Employee {
	
	private int id;
	private String name;
	private String role;
	
	public Employee (int id, String name, String role) {
		setId(id);
		setName(name);
		setRole(role);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}

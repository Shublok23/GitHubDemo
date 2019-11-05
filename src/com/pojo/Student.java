package com.pojo;

public class Student {
	private int id;
	private String name;
	private String pass;
	

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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String toString() {
		return "[id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}
}

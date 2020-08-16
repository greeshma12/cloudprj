package com.fs.cloudfirestoredemo.model;

public class Cafe {
	private String name;
	private String city;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Cafe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cafe(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	

}

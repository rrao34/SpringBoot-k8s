package com.springboot.first.bean;

public class StudentBean {

	private int id;
	private String name;
	
	private String Address;

	/**
	 * @param id
	 * @param name
	 * @param address
	 */
	public StudentBean(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		Address = address;
	}

	/**
	 * 
	 */
	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

}

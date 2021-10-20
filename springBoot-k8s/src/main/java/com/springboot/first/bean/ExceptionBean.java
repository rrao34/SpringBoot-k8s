package com.springboot.first.bean;

import java.util.Date;

public class ExceptionBean {

	private Date timeStamp;
	private String message;
	private String description;

	/**
	 * 
	 */
	public ExceptionBean() {
		super();
	}

	/**
	 * @param timeStamp
	 * @param message
	 * @param description
	 */
	public ExceptionBean(Date timeStamp, String message, String description) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.description = description;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

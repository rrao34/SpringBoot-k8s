/**
 * 
 */
package com.springboot.first.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Rohit Rao
 *
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class StudentIdExistsException extends RuntimeException {

	/**
	 * @param arg0
	 * @param arg1
	 */
	public StudentIdExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public StudentIdExistsException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public StudentIdExistsException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}

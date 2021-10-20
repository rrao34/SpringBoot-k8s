package com.springboot.first.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.first.bean.ExceptionBean;

@ControllerAdvice
@RestController
public class ExceptionManagement extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = RecordNotFoundException.class)
	public ResponseEntity<Object> requestedResultNotFound(RecordNotFoundException ex, WebRequest request) {
		return new ResponseEntity<>(new ExceptionBean(new Date(), ex.getMessage(), "Student is not valid"),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = StudentIdExistsException.class)
	public ResponseEntity<Object> requestedItemExistsInRecords(StudentIdExistsException ex, WebRequest wr) {
		return new ResponseEntity<>(
				new ExceptionBean(new Date(), ex.getMessage(), "Student id existsin records, try with no-id or new id"),
				HttpStatus.CONFLICT);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		return new ResponseEntity<>(new ExceptionBean(new Date(), ex.getBindingResult().toString(), "Field Validation failed"), status.BAD_REQUEST);
	}
}

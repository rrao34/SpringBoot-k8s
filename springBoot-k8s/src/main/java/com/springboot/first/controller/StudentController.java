package com.springboot.first.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.first.bean.StudentBean;
import com.springboot.first.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	private MessageSource message;
	

	@GetMapping(path = "/")
	public String getStudentTest() {
		return "Application 'SpringBoot-K8s' is up and running on GKE";
	}

	@GetMapping(path = "/students")
	public List<StudentBean> getStudents() {
		return studentService.getStudents();
	}

	@GetMapping(path = "/students/{id}")
	public  StudentBean getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}

	@PostMapping(value = "/newstudent")
	public ResponseEntity<Object> addNewStudent(@Validated @RequestBody StudentBean newStudent) {
		studentService.addNewStudent(newStudent);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newStudent.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/students/{id}")
	public  void deleteStudentById(@PathVariable int id) {
		studentService.deleteStudentById(id);
	}
	

}

package com.springboot.first.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.springboot.first.bean.StudentBean;
import com.springboot.first.exception.RecordNotFoundException;
import com.springboot.first.exception.StudentIdExistsException;

@Component
public class StudentService {

	static List<StudentBean> students = new ArrayList<>();

	static {
		students.add(new StudentBean(1, "John", "Milano"));
		students.add(new StudentBean(2, "Marko", "Bologna"));
		students.add(new StudentBean(3, "Tim", "Verona"));

	}

	/**
	 * @return
	 */
	public static List<StudentBean> getStudents() {
		return students;
	}

	/**
	 * @param id
	 * @return
	 */
	public static StudentBean getStudentById(int id) {
		Optional<StudentBean> student = students.stream().filter(s -> (s.getId() == id)).findFirst();
		if (student.isPresent()) {
			return student.get();
		}
		throw new RecordNotFoundException("Student's id - '" + id + "' is not found in records");
	}

	/**
	 * @param students
	 * @param newStudent
	 */
	public void addNewStudent(StudentBean newStudent) {
		if (newStudent.getId() == 0) {
			newStudent.setId(students.size() + 1);
			students.add(newStudent);
		} else {

			Optional<StudentBean> student = students.stream().filter(s -> (s.getId() == newStudent.getId()))
					.findFirst();
			if (student.isPresent()) {
				throw new StudentIdExistsException(
						"Given student id - '" + newStudent.getId() + "' already exists in record");
			} else {
				students.add(newStudent);
			}

		}

	}

	/**
	 * @param id
	 * @return
	 */
	public void deleteStudentById(int id) {
		Optional<StudentBean> student = students.stream().filter(s -> (s.getId() == id)).findFirst();
		if (student.isPresent()) {
			students.remove(student.get());
		} else {
			throw new RecordNotFoundException("Student's id - '" + id + "' is not found in records");
		}
		
	}
}

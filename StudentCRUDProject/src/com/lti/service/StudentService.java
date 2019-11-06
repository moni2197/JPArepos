package com.lti.service;

import java.util.List;

import com.lti.model.Student;

public interface StudentService {
	public boolean addStudent(Student student);
	public List<Student> findAllStudents();
	public Student findStudentByRollNumber(int rollNumber);
	public Student modifyStudent(Student student);
	public boolean removeStudent(int rollNumber);
	
	

}

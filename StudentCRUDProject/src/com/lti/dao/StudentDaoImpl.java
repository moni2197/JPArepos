package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.lti.model.Student;
import com.lti.utils.JpaUtils;

public class StudentDaoImpl implements StudentDao
{

	private EntityManager entityManager;
	
	public StudentDaoImpl(){
		entityManager = JpaUtils.getEntityManager();
	}
	
	@Override
	public int createStudent(Student student) {
		entityManager.persist(student);
		return 1;
	}

	@Override
	public Student readStudentByRollNumber(int rollNumber) {
		Student student= entityManager.find(Student.class, rollNumber);
		return student;
	}

	@Override
	public List<Student> readAllStudents() {
		
		return null;
	}

	@Override
	public Student updateStudent(Student student) {
		Student student2 = entityManager.merge(student);
		return student2;
	}

	@Override
	public int deleteStudent(int rollNumber) {
		Student student = readStudentByRollNumber(rollNumber);
		if(student!=null){
				
				
				entityManager.remove(student);
				
				return 1;
		}
		return 0;
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void rollbackTransaction() {
		entityManager.getTransaction().rollback();
		
	}
	

}

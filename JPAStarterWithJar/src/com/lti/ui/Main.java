package com.lti.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.rmi.ssl.SslRMIClientSocketFactory;

import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {
	 Student student= new Student(15,"ABCD",80);
	 Student mStudent=new Student();
	 Scanner scan=new Scanner(System.in);
	 System.out.println("Enter ID: ");
	 int id=scan.nextInt();
	 System.out.println("Enter name");
	 String name=scan.next();
	 System.out.println("Enter marks");
	 int marks=scan.nextInt();
	 mStudent.setRollNumber(id);
	 mStudent.setStudentName(name);
	 mStudent.setAvgScore(marks);
	 //JPA Api
	 EntityManagerFactory factory =  Persistence.createEntityManagerFactory("JPA_PU"); 
	 EntityManager entityManager = factory.createEntityManager();
	 entityManager.getTransaction().begin();
	 //entityManager.persist(student);
	 //entityManager.persist(mStudent);
	//code to find entity


	 
	 entityManager.getTransaction().commit();
	 System.out.println("Student object saved.");

	 
	 Student fstudent=entityManager.find(Student.class, student.getRollNumber());
	 System.out.println(fstudent);
	 
	 fstudent.setAvgScore(65.5);
	 System.out.println("After updating student object");
	 entityManager.getTransaction().begin();
	 entityManager.merge(fstudent);
	 entityManager.getTransaction().commit();
	 fstudent=entityManager.find(Student.class, student.getRollNumber());
	 System.out.println(fstudent);
	 
	 
	 System.out.println("After remove student object");
	 entityManager.remove(fstudent);
	 fstudent=entityManager.find(Student.class, student.getRollNumber());
	 System.out.println(fstudent);
	 
	 

	 
	 
	 
	 
	}

}

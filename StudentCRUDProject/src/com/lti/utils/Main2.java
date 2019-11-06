package com.lti.utils;

import java.util.Scanner;

import com.lti.model.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;


public class Main2 {
	private static StudentService service = null;
	static{
		service = new StudentServiceImpl();
	}
	public static void main(String args[])
	{
		Student student;
		Student student3=new Student();
		Scanner scan=new Scanner(System.in);
		char ch;
		do{
			
			System.out.println("1.Add student");
			System.out.println("2.Display student");
			System.out.println("3.Update student");
			System.out.println("4.Remove student");
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:System.out.println("Enter Roll Number");
					int rollno=scan.nextInt();
					System.out.println("Enter the Name");
					String name=scan.next();
					System.out.println("Enter the marks");
					int marks=scan.nextInt();
					student = new Student(rollno,name,marks);
					boolean result=service.addStudent(student);
					if(result)
						System.out.println("Student added");
					else
						System.out.println("Student not added");
					break;
			case 2:System.out.println("Enter roll no to display");
					int rollno1=scan.nextInt();
					student=service.findStudentByRollNumber(rollno1);
					System.out.println(student);
					break;
			case 3:System.out.println("Enter roll no to update");
					int rollno2=scan.nextInt();
					//String name=scan.next();
					student=service.findStudentByRollNumber(rollno2);
					
					student3.setRollNumber(rollno2);
					System.out.println("Enter name to be updated");
					String name1=scan.next();
					student3.setStudentName(name1);
					System.out.println("Enter score to be updated");
					int marks1=scan.nextInt();
					student3.setAvgScore(marks1);
					
					Student student2=service.modifyStudent(student3);
					System.out.println(student2);
					break;
			case 4:System.out.println("Enter roll no to delete");
					int rollno3=scan.nextInt();
					boolean delete=service.removeStudent(rollno3);
					if(delete)
						System.out.println("Student deleted");
					break;
					
			
			}
			System.out.println("Do you want to continue?");
			ch=scan.next().charAt(0);
		}while(ch=='y'||ch=='Y');
	}
}

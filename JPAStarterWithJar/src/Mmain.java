import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;

public class Mmain {

	public static void main(String[] args) {
		//Student student=new Student(1,"ABC",50);
		Student mStudent=new Student();
		Student fstudent=new Student();
		Scanner scan=new Scanner(System.in);
		int choice;
		 EntityManagerFactory factory =  Persistence.createEntityManagerFactory("JPA_PU"); 
		 EntityManager entityManager = factory.createEntityManager();
		 char ch;
		do{
			
			System.out.println("1. Enroll a student");
			System.out.println("2. Update the student record");
			System.out.println("3. Delete");
			System.out.println("Enter your choice");
			choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				 System.out.println("Enter ID: ");
				 int id=scan.nextInt();
				 System.out.println("Enter name");
				 String name=scan.next();
				 System.out.println("Enter marks");
				 int marks=scan.nextInt();
				 mStudent.setRollNumber(id);
				 mStudent.setStudentName(name);
				 mStudent.setAvgScore(marks);
				 entityManager.getTransaction().begin();
				 //entityManager.persist(student);
				 entityManager.persist(mStudent);
				 entityManager.getTransaction().commit();
				 System.out.println("Student object saved.");
				 break;
			case 2:
				System.out.println("Enter roll number for updating");
				int roll=scan.nextInt();
				fstudent=entityManager.find(Student.class, roll);
				 System.out.println(fstudent);
				 
				 System.out.println("Enter the new marks");
				 int upmarks=scan.nextInt();
				 fstudent.setAvgScore(upmarks);
				 System.out.println("After updating student object");
				 
				 entityManager.getTransaction().begin();
				 entityManager.merge(fstudent);
				 entityManager.getTransaction().commit();
				 fstudent=entityManager.find(Student.class, roll);
				 System.out.println(fstudent);
				 break;
			case 3:
				System.out.println("Enter roll for deletion");
				int droll=scan.nextInt();
				fstudent=entityManager.find(Student.class, droll);
				entityManager.getTransaction().begin();
				entityManager.remove(fstudent);
				entityManager.getTransaction().commit();
				System.out.println("Student Deleted");
				break;

			
			}
			System.out.println("Do you want to continue?");
			ch=scan.next().charAt(0);
			
		}while(ch=='y'||ch=='Y');
	}
}

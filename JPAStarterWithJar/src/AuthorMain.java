import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AuthorMain {
	public static void main(String[] args) {
		
		Author author=new Author();
		Author author1=new Author();
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Do you want to insert an author?");
		char ch2=scan.next().charAt(0);
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager=factory.createEntityManager();
		
		if(ch2=='y')
		{
		System.out.println("Enter author ID:");
		int id=scan.nextInt();
		System.out.println("Enter author first name");
		String name=scan.next();
		System.out.println("Enter Middle Name");
		String mName=scan.next();
		System.out.println("Enter Last Name");
		String lName=scan.next();
		System.out.println("Enter phoneNo");
		int phoneNo=scan.nextInt();
		author.setAuthorId(id);
		author.setFirstName(name);
		author.setMiddleName(mName);
		author.setLastName(lName);
		author.setPhoneNo(phoneNo);

		entityManager.getTransaction().begin();
		entityManager.persist(author);
		entityManager.getTransaction().commit();
		System.out.println("Author Inserted");
		}
		System.out.println("Do you want to update?");
		char ch=scan.next().charAt(0);
		if(ch=='y')
		{
			System.out.println("Enter the id for updating");
			int id1=scan.nextInt();
			author1=entityManager.find(Author.class, id1);
			System.out.println(author1);
			System.out.println("Enter the new first name");
			String name1=scan.next();
			author1.setFirstName(name1);
			System.out.println("After updating author..");
			author1=entityManager.find(Author.class, id1);
			entityManager.getTransaction().begin();
			entityManager.merge(author1);
			entityManager.getTransaction().commit();
			System.out.println(author1);
			
		}
		System.out.println("Do you want to delete?");
		char ch1=scan.next().charAt(0);
		if(ch1=='y')
		{
			System.out.println("Enter the id you want to delete");
			int did=scan.nextInt();
			author1.setAuthorId(did);
			author1=entityManager.find(Author.class,author1.getAuthorId());
			System.out.println(author1);
			entityManager.getTransaction().begin();
			entityManager.remove(author1);
			
			entityManager.getTransaction().commit();
			System.out.println("Author deleted");
			author1=entityManager.find(Author.class,author1.getAuthorId());
			System.out.println(author1);
			
		}
		scan.close();
	}
}

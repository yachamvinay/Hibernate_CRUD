package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class CreateTeacher {
public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Teacher.class)
				                     .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create a student object
			System.out.println("Creating new teacher object...");
			Teacher teacher1 = new Teacher("vinay", "yacham", "vinay@gl.com");
			Teacher teacher2 = new Teacher("vijay", "yacham", "vijay@gl.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the teacher ..."); 
			session.save(teacher1);
			session.save(teacher2);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
			
		}
		
	}
}


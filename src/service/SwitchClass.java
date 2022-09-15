package service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class SwitchClass {
	public static void main(String[] args) {
		int ch; 
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter your choice");  
	 ch=Integer.parseInt(sc.nextLine());  
	
	switch(ch) {
	case 1:
		SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Teacher.class)
        .buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();

		try {
			//create a student object
			System.out.println("Creating new teacher object...");
			Teacher teacher1 = new Teacher("Sarath", "Vimal", "sarath@gl.com");
			Teacher teacher2 = new Teacher("Himanshu", "Kumar", "himanshu@gl.com");
	
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
		break;
	case 2:
		 factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Teacher.class)
        .buildSessionFactory();

		//create session
		 session = factory.getCurrentSession();
	
		try {
		//create a student object
		System.out.println("Creating new teacher object...");
		Teacher teacher = new Teacher("Sarath", "Binny", "sarath@gl.com");
	
		//start a transaction
		session.beginTransaction();
	
		//save the student object
		System.out.println("saving the teacher ..."); 
		session.save(teacher);
	
		//commit transaction
		session.getTransaction().commit();
	
		System.out.println("Done!");
	
		//find out the teacher's id
		System.out.println("saved student" + teacher.getId());		
	
		//get a new session and start transaction
		session=factory.getCurrentSession();
		session.beginTransaction();
	
		//retrieve student based on the id
		System.out.println("Getting student with id"+ teacher.getId());
	
		Teacher tempTeacher = session.get(Teacher.class, teacher.getId());
	
		System.out.println(tempTeacher);
	
		session.getTransaction().commit();
	
		System.out.println("Done ");
		}
		finally {
			factory.close();
		}
	break;
	case 3:
		factory = new Configuration().configure("hibernate.cfg.xml")
		.addAnnotatedClass(Teacher.class)
		.buildSessionFactory();

		// create session
		 session = factory.getCurrentSession();

		try {

		int teacherId = 1;

		// start a transaction
		session.beginTransaction();

		System.out.println("getting teacher with id :" + teacherId);

		//fetching record where teacher id = 1
		Teacher tempTeacher = session.get(Teacher.class, teacherId);
	
		//updating value using setters
		System.out.println("updating teacher--");
		tempTeacher.setF_name("Amit");
		
		//commit transaction
		session.getTransaction().commit();
	
		session = factory.getCurrentSession();
		session.beginTransaction();
	
		// update email for all teacher whose f_Name is Amit
		System.out.println("update email for all teachers");
		session.createQuery("update Teacher set email = 'random1@gl.com' where f_Name='Amit'").executeUpdate();
		
		//commit transaction
		session.getTransaction().commit();
	
		System.out.println("Done!");
		session.close();
	} finally {
		factory.close();
	}
		break;	
	case 4:
		// create session factory
				 factory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Teacher.class)
						
						.buildSessionFactory();

				// create session
				 session = factory.getCurrentSession();

				try {

					int teacherId = 1;

					// start a transaction
					session.beginTransaction();

					System.out.println("getting teacher with id :" + teacherId);

					// fetching record where teacher id = 1
					Teacher tempTeacher = session.get(Teacher.class, teacherId);

					// deleting record using session.delete method
					System.out.println("delete teacher--");
					session.delete(tempTeacher);

					// commit transaction
					session.getTransaction().commit();

					session = factory.getCurrentSession();
					session.beginTransaction();

					// delete teacher with id = 2 using createQuery
					System.out.println("delete teacher with id = 2");
					session.createQuery("delete from Teacher where id = 2 ").executeUpdate();

					// commit transaction
					session.getTransaction().commit();

					System.out.println("Done!");
				} finally {
					factory.close();
				}
			
	break;

		default:
			System.out.println("error");
	}
	}
}
		

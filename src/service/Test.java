package service;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


import entity.Teacher;
import java.util.List;
public class Test {
	public static void main(String[] args) {
		System.out.println("Connecting to database");
		SessionFactory factory=null;
		Session session=null;
		List<Teacher> teachers = null;
		try {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		System.out.println("created");
		
		
		Teacher t1 = new Teacher("vinay","vijay","vinay@gmail.com");
		Teacher t2 = new Teacher("siva","vani","vani@gmail.com");
		Teacher t3 = new Teacher("siva","sankar","sankar@gmail.com");
		Teacher t4 = new Teacher("a","b","ab@gmail.com");
		//Transaction tx=null;
		
			session = factory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			//session.save(t1);
			//session.save(t2);
			//session.save(t3);
			//session.save(t4);
			//Teacher teacher = session.get(Teacher.class, 1);
			 teachers = session.createQuery("from Teacher where email like '%gl.com'").list();
			
			tx.commit();
			//session.close();
		}
		catch(Exception e)
		{
			System.out.println("error"+e.getMessage());
			//e.printStackTrace();
			//tx.rollback();
			
			
		}
		finally {
			session.close();
			factory.close();
		}
		for(Teacher teacher:teachers)
			System.out.println(teacher);
		
			
	}

}

package com.company.Instuctor_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.company.Instuctor_mapping.model.Course;
import com.company.Instuctor_mapping.model.Instructor;
import com.company.Instuctor_mapping.model.InstructorDetail;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory=new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();
    	Session session=factory.openSession();
    	session.beginTransaction();
    	/*
    	InstructorDetail det=new InstructorDetail();
    	det.setYoutube_channel("http://youtube.com");
    	det.setHobby("sketching");
        Instructor ins = new Instructor();
        ins.setFirstName("Diana");
        ins.setLastName("Dsouza");
    	ins.setEmail("diana@gmail.com");
    	ins.setInstructor_Detail(det);
        System.out.println("Successfully inserted");
		

        session.persist(det);
        session.persist(ins);
        session.getTransaction().commit();
      
        
      
        int theId = 1;
		Instructor tempInstructor = session.get(Instructor.class, theId);
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		session.save(tempCourse1);
		session.save(tempCourse2);
		session.getTransaction().commit();
		System.out.println("Done!");
		*/
		int theId = 1;
		Course tempCourse = session.get(Course.class, theId);

		System.out.println("Deleting course: " + tempCourse);

		session.delete(tempCourse);

		session.getTransaction().commit();

		System.out.println("Done!");
		/*
    	INstructor e=session.get(Instructor.class, 1);
		if(e!=null)
		{
			session.delete(e);
			System.out.println("deleted sucessfully..");
			session.getTransaction().commit();
		}
    	*/
		  session.close();
  
    }
}

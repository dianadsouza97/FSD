package com.company.Instuctor_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
				addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
    	Session session=factory.openSession();
    	InstructorDetail det=new InstructorDetail();
    	det.setYoutube_channel("http://youtube.com");
    	det.setHobby("sketching");
        Instructor ins = new Instructor();
        ins.setFirstName("Diana");
        ins.setLastname("Dsouza");
    	ins.setEmail("diana@gmail.com");
    	ins.setInstructorDetailId(det);
        
    	session.beginTransaction();
         session.persist(det);
         session.persist(ins);
         session.getTransaction().commit();
         session.close();
  
    }
}

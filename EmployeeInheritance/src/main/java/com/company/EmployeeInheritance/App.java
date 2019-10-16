package com.company.EmployeeInheritance;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.company.EmployeeInheritance.Emploees.Clerk;
import com.company.EmployeeInheritance.Emploees.Employee;
import com.company.EmployeeInheritance.Emploees.HR;
import com.company.EmployeeInheritance.Emploees.Manager;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Employee.class).addAnnotatedClass(Manager.class).addAnnotatedClass(HR.class)
					.addAnnotatedClass(Clerk.class).buildSessionFactory();
			Session session = factory.openSession();
			Employee emp = new Employee(1, "Diana", 21, new Date());
			Manager man = new Manager(2, "Kitty", 21, new Date(), 3);
			HR hr = new HR(3, "Karunya", 21, new Date(), "Recruitment");
			Clerk clerk = new Clerk(2, "Kitty", 21, new Date(), 30000);

			session.getTransaction().begin();
			session.save(emp);
			session.save(man);
			session.save(hr);
			session.save(clerk);

			session.getTransaction().commit();
			System.out.println("ok..");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

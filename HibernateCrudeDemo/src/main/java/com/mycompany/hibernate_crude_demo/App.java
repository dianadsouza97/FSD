package com.mycompany.hibernate_crude_demo;

import java.util.List;
import java.util.Scanner;

import com.mycompany.hibernate_crude_demo.dao.Employeedao;
import com.mycompany.hibernate_crude_demo.dao.EmployeedaoImpl;
import com.mycompany.hibernate_crude_demo.sharedemp.SharedEmployee;
import static java.lang.System.in;
/**
 * Hello world!
 *
 */
public class App 
{
	private static Scanner sc=new Scanner(in);
    public static void main( String[] args )
    {
    	Employeedao dao=new EmployeedaoImpl();
        try {
			int choice=0;
			do {
				System.out.println("1.create employee.");
        		System.out.println("2.display all available employee.");
        		System.out.println("3.find employee by id.");
        		System.out.println("4.find employee by custom id.");
        		System.out.println("5.remove by id.");
        		System.out.println("0.exit");
        		System.out.print("your choice: ");				
				choice=sc.nextInt();
				switch(choice) {
				case 1:
					System.out.println("First name:");
					String fName=sc.next();
					System.out.println("Last name:");
					String lName=sc.next();
					System.out.println("Email:");
					String email=sc.next();
					
					 dao.createEmployee(new SharedEmployee(fName, lName,email));
					  System.out.println("inserted");
					 break;
				case 2:
					List<SharedEmployee> se=dao.getAllEmployee();
		        	for(SharedEmployee see:se)
		        	{
		        		System.out.printf("%s %s %s",see.getFirstName(),see.getLastName(),see.getEmail());
		        	}
		        	break;
				case 3:
					int id=sc.nextInt();
					SharedEmployee sEmployee=dao.findById(id);
					if(sEmployee==null)
						System.out.println("Not found");
					else
						System.out.println(sEmployee);
					break;
				case 4:
					System.out.println("custom id: ");
					String cid=sc.next();
					dao.findByGeneratedId(cid);
					break;
				case 5:
					System.out.print("enter employee id: ");
					id=sc.nextInt();
					dao.deleteEmployee(id);
					break;
				case 6:
					System.out.print("enter employee id: ");
					id=sc.nextInt();
					System.out.println("First name:");
					String fname=sc.next();
					System.out.println("Last name:");
					String lname=sc.next();
					System.out.println("Email:");
					String Email=sc.next();
					
					 dao.updateEmployee(id,fname, lname,Email);
					
					break;
					
				default:
					break;
				}
				
				
			}while(choice!=0);
			 
        	
        	
        	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}

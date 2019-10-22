package com.mycompany.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyApplicationListener implements ServletContextListener {
private String email=null;
   
    public void contextDestroyed(ServletContextEvent sce)  { 
        System.out.println("Destroyed"+email);
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         email=sce.getServletContext().getInitParameter("email");
         System.out.println("Context initialised"+email);
    }
	
}

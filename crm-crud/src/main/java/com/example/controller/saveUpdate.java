package com.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;


@WebServlet(name = "setUpdate", urlPatterns = { "/setupdate" })
public class saveUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private CustomerDao dao;
    public saveUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao=new CustomerDaoImpl();
		int id=Integer.parseInt(request.getParameter("id"));
		String fName=request.getParameter("firstName");
		String lName=request.getParameter("lastName");
		String email=request.getParameter("email");
		Customer c=new Customer();
		c.setId(id);
		c.setFirstName(fName);
		c.setLastName(lName);
		c.setEmail(email);
	
		dao.updateCust(c);
		RequestDispatcher view=request.getRequestDispatcher("list.do");
		view.forward(request, response);
	}
	
}

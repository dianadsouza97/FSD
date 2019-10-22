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



@WebServlet("/update.do")
public class updateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
   private CustomerDao dao;
    public updateCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);

	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao = new CustomerDaoImpl();
		
		Customer cust=dao.getCustomerById(Integer.parseInt(request.getParameter("customerId").toString()));
		request.setAttribute("customer", cust);
		RequestDispatcher view = request.getRequestDispatcher("updateForm.jsp");
		view.include(request, response);
	}
}

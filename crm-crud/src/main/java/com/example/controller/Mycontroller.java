package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;

@WebServlet("/mycontroller.do")
public class Mycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String FName, LName, Email;
	private List<String> errors = null;

	public Mycontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		errors = new LinkedList<String>();
		FName = request.getParameter("fName");
		if ((FName == null) || (FName.length() < 3)) {
			errors.add("first name can't be null or less than 5 chars");
		}
		LName = request.getParameter("lName");
		if ((FName == null) || (FName.length() < 3)) {
			errors.add("last name can't be null or less than 5 chars");
		}

		Email = request.getParameter("email");

		if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			RequestDispatcher view = request.getRequestDispatcher("list-customer.jsp");
			view.forward(request, response);
		} else {
			Customer l = new Customer(FName, LName, Email);
			request.setAttribute("success", l);
			CustomerDao dao = new CustomerDaoImpl();
			dao.createCustomer(l);
			RequestDispatcher view = request.getRequestDispatcher("list.do");
			view.forward(request, response);

		}
	}

}

package com.mycompany.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.model.Customer;

public class AddEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String custType=null;
	private int Id=-1;
	private String Name=null;
	 
	private List<String> errors=null;
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
		errors = new ArrayList<String>();
		String sid = request.getParameter("id");
		try {
			Id=Integer.parseInt(sid);
		} catch (Exception e) {
			// TODO: handle exception
			errors.add("Id field must be numeric");
		}
		Name=request.getParameter("name");
		if(Name.length()<=5)
		{
			errors.add("invalid name");
		}
		custType=request.getParameter("customer");
		if(custType.equals("Unknown"))
		{
			errors.add("select customer type");
		}
		if(!errors.isEmpty())
		{
			request.setAttribute("ERROR",errors);
			RequestDispatcher view=request.getRequestDispatcher("EntryForm");
			view.forward(request, response);
		}
		else
		{
			request.setAttribute("SUCCESS",new Customer(Id,Name,custType));
			RequestDispatcher view=request.getRequestDispatcher("success.do");
			view.forward(request, response);
		}

	}
}



package com.mycompany.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String custType;
	private int Id;
	private String Name;
	 
	private List<String> errors;
	
	
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
		if(Name.length()<=8)
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
			RequestDispatcher view=request.getRequestDispatcher("Error.html");
			view.forward(request, response);
		}
		else
		{

			RequestDispatcher view=request.getRequestDispatcher("Success.html");
			view.forward(request, response);
		}

	}
}

}

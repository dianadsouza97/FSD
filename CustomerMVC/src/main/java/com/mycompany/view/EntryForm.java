package com.mycompany.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EntryForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       List<String> l=null;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	@SuppressWarnings("unchecked")
	private void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		l=(List<String>) request.getAttribute("ERROR");

		if(l!=null) {
			out.println("please correct the bellow error(s)<br/>");
			for(String str:l)
			{
				out.println("<font color='red'>"+str+"</font><br/>");
			}
			out.println("<a href='Error.html'>try again</a>");
		  }
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<!-- Default form login -->\r\n" + 
				"<form class=\"text-center border border-light p-5\" action=\"add_entry.do\" method=\"post\">\r\n" + 
				"\r\n" + 
				"    <p class=\"h4 mb-4\">Customer Registration.</p>\r\n" + 
				"\r\n" + 
				"    \r\n" + 
				"    <input type=\"text\" id=\"defaultLoginFormEmail\" class=\"form-control mb-4\" placeholder=\"ID\" name=\"id\">\r\n" + 
				"\r\n" + 
				"    \r\n" + 
				"    <input type=\"text\" id=\"defaultLoginFormPassword\" class=\"form-control mb-4\" placeholder=\"Name\" name=\"name\">\r\n" + 
				"\r\n" + 
				" <select class=\"browser-default custom-select\" name=\"customer\">\r\n" + 
				"  <option value=\"Unknown\">Select A Customer</option>\r\n" + 
				"  <option value=\"regular\">Regular</option>\r\n" + 
				"  <option value=\"premium\">Premium</option>\r\n" + 
				"\r\n" + 
				"</select>\r\n" + 
				"\r\n" + 
				"    <!-- Sign in button -->\r\n" + 
				"    <button class=\"btn btn-info btn-block my-4\" type=\"submit\">Add A New Customer</button>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</form>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

}

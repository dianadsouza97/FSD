package com.example.controller;

import java.io.IOException;
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

@WebServlet("/search.do")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerDao dao = null;

	@Override
	public void init() throws ServletException {
		dao = new CustomerDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProccess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProccess(request, response);
	}

	protected void doProccess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Customer> list=dao.searchCustomer(request.getParameter("search"));
		if(list.isEmpty())
		{
			RequestDispatcher view=request.getRequestDispatcher("list.do");
			view.forward(request, response);
		}
		else
		{
			request.setAttribute("customers", list);
			RequestDispatcher view=request.getRequestDispatcher("list-customer.jsp");
			view.forward(request, response);
		}

	}
}

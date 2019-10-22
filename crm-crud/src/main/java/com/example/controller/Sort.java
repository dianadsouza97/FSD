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

@WebServlet("/sort.do")
public class Sort extends HttpServlet {
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
		String str = request.getParameter("sort");

		List<Customer> customers = dao.sortCustomer(str);

		request.setAttribute("customers", customers);
		RequestDispatcher view = request.getRequestDispatcher("list-customer.jsp");
		view.forward(request, response);
	}

}

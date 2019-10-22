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

@WebServlet("/delete.do")
public class deleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerDao dao;

	public deleteCustomer() {
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
		dao = new CustomerDaoImpl();
		int custId = Integer.parseInt(request.getParameter("customerId").toString());

		Customer c = dao.getCustomerById(custId);

		dao.deleteCust(c);
		RequestDispatcher view = request.getRequestDispatcher("list.do");
		view.forward(request, response);

	}
}

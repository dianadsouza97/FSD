package com.example.dao;

import java.util.List;

import com.example.model.Customer;

public interface CustomerDao {
	public void createCustomer(Customer customer);
	public void deleteCust(Customer customer);
	public void updateCust(Customer customer);
	public List <Customer> getAllCustomer();
	public Customer getCustomerById(int id);
	public List <Customer> searchCustomer(String str);
	public List <Customer> sortCustomer(String str);
}

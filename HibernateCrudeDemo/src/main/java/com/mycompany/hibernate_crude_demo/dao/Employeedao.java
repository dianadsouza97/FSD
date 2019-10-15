package com.mycompany.hibernate_crude_demo.dao;

import java.util.List;

import com.mycompany.hibernate_crude_demo.sharedemp.SharedEmployee;

public interface Employeedao {
	
	public void createEmployee(SharedEmployee sEmployee);
	public List<SharedEmployee> getAllEmployee();
	public SharedEmployee findById(int id);
	public  void findByGeneratedId(String Custid);
	public void deleteEmployee(int id);
	public void updateEmployee(int id,String fname,String lname,String Email);
}


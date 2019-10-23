package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class Tester {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Customer customer=context.getBean("cust",Customer.class);
		System.out.println(customer);
	}

}

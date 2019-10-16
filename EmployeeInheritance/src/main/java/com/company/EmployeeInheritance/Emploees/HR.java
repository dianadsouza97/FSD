package com.company.EmployeeInheritance.Emploees;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@DiscriminatorValue("HR")
@EqualsAndHashCode(callSuper = false)

public class HR extends Employee{
	private String Event;
	public HR(int id,String name,int age,Date joiningDate,String event) {
		super(id,name,age,joiningDate);
		Event=event;
	}
	
}

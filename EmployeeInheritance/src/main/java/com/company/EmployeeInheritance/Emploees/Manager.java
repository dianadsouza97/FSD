package com.company.EmployeeInheritance.Emploees;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("Manager")
@EqualsAndHashCode(callSuper = false)
public class Manager extends Employee{
	private int Teams;
	public Manager(int id,String name,int age,Date joiningDate,int teams) {
		super(id,name,age,joiningDate);
		Teams=teams;
	}
	
}

package com.company.EmployeeInheritance.Emploees;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("Clerk")

public class Clerk extends Employee{
	private int Loc;
	public Clerk(int id,String name,int age,Date joiningDate,int location) {
		super(id,name,age,joiningDate);
		Loc=location;
	}
}

package com.company.EmployeeTablePerClass.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "REGULAR_EMPLOYEE")
@PrimaryKeyJoinColumn(name = "ID")
@Data
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class Regular_Employee extends Employee {
	@Column(name = "salary")
	private float salary;

	@Column(name = "bonus")
	private int bonus;
}

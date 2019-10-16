package com.company.Instuctor_mapping.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="instructor")
public class Instructor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4009701963882017845L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="id")
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	//@OneToOne(cascade ={ CascadeType.DETACH , CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_id")
	private InstructorDetail instructor_Detail  ;
	
	@OneToMany(mappedBy="instructor_Det",cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Course> courses;
	

	public Instructor() {}

	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void add(Course tempCourse) {
		
		if (courses == null) {
			courses = new ArrayList<Course>();
		}
		
		courses.add(tempCourse);
		
		tempCourse.setInstructor_Det(this);
	}
	
}

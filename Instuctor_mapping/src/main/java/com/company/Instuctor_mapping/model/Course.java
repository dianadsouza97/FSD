package com.company.Instuctor_mapping.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="courses")
public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="id")
	private int id;
	
	private String title;
	
	
	@ManyToOne(cascade ={ CascadeType.DETACH , CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
	
	@JoinColumn(name="instructor_id")
	private Instructor instructor_Det ;
	public Course() {

	}
	public Course(String title) {
		this.title = title;
	}
}

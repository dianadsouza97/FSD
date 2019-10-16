package com.company.Instuctor_mapping.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="instructorDetail")
public class InstructorDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1415728261642614353L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	

	private String youtube_channel;
	
	
	private String hobby;
	
	@OneToOne(mappedBy="instructor_Detail",cascade=CascadeType.ALL)
	private Instructor instructor ;
	public InstructorDetail() {
		super();
	}

}

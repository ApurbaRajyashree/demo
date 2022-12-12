package com.texas.reactcollege.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Entity
@Table(name="students")
public class Students {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="student_id")
	private long studentId;
	
	@Column(name="student_Name", unique=true, nullable=false)
	private String studentName;
	
	@Column(name="student_Address", unique=false, nullable=false)
	private String studentAddress;
	
	@Column(name="student_Phoneno", unique=true, nullable=false)
	private String studentPhoneno;
	
	@Column(name="student_Gender", unique=false, nullable=false)
	private String studentGender;
	
	@Column(name="student_Age", unique=false, nullable=false)
	private long studentAge;
	
	@ManyToOne(cascade= CascadeType.ALL , fetch=FetchType.EAGER)
	@JoinColumn(name="department_id_fk", referencedColumnName="department_id")
	@JsonBackReference
	private Department department;
}

package com.texas.reactcollege.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Entity
@Table(name="department")
public class Department {

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="department_id")
	private long departmentId;
	
	@Column(name="department_name", unique=false, nullable=false)
	private String departmentName;
	
	@Column(name="department_address", unique=false, nullable=false)
	private String departmentAddress;
	
	@Column(name="department_phoneno", unique=true, nullable=false)
	private String departmentPhoneNo;
	
	
	@ManyToOne(cascade= CascadeType.ALL , fetch=FetchType.EAGER)
	@JoinColumn(name="college_id_fk", referencedColumnName="college_id")
	@JsonBackReference
	private College college;
	
	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="department")
	@JsonManagedReference
	private List<Students> students;
}

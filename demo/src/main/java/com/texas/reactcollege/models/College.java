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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


@Entity
@Table(name="college")
public class College {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="college_id")
	private long collegeid;
	
	@Column(name="college_name",unique=true,  nullable=false)
	private String collegeName;
	
	@Column(name="college_address",unique=false, nullable=false)
	private String collegeAddress;
	
	
	@OneToOne(cascade= CascadeType.ALL , fetch=FetchType.EAGER)
	@JoinColumn(name="college_contact_info_id_fk", referencedColumnName = "college_contact_info_id")
	@JsonManagedReference
	private CollegeContactInfo collegeContactInfo;
	
	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY , mappedBy="college")
	@JsonManagedReference
	private List<Department> department;
	
}

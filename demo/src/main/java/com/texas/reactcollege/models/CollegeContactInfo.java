package com.texas.reactcollege.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


@Entity
@Table(name="college_contact_info")
public class CollegeContactInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="college_contact_info_id" )
	private long collegeContactInfoId;
	
	
	@Column(name="college_phone_no",unique= true , nullable=false)
	private String collegePhoneNo;
	
	@Column(name="college_email", unique=true , nullable=false)
	private String collegeEmail;
	
	@OneToOne(mappedBy="collegeContactInfo")
	@JsonBackReference
	private College college;
	
}

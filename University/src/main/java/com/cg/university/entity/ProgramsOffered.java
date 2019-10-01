package com.cg.university.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="ProgramsOffered")
public class ProgramsOffered implements Serializable{

    @Id
    @Column(name="programName")
	private String programName;
	private String description;	
	private String applicantEligibility;	
	private String duration;	
	private String degreeCertificate;
	@JsonIgnore
    @OneToOne(mappedBy = "programsOffered")
	private ProgramsScheduled programScheduled;
	 
}

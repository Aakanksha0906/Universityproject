package com.cg.university.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Application {
	  @Id	  
	  @Column(name="applicationId")	  
	  @SequenceGenerator(name="applicationseq",
	  sequenceName="application_seq",initialValue= 100,allocationSize=1)	  
	  @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="applicationseq")
		private int applicationId;
		private String fullName;
		private Date dateOfBirth;
		private String highestQualification;
		private int marksObtained;
		private String goals;
		private String emailID;		  
		private String status; 
		private Date dateOfInterview;
		private int scheduledProgramID;
	
	
	
	
}
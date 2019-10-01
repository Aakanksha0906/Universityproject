package com.cg.university.entity;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;



@Data
@Entity
@Table(name="ProgramsScheduled")
public class ProgramsScheduled implements Serializable{
	@Id 
	@SequenceGenerator(name="myseq",sequenceName ="program_seq", initialValue= 100, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="myseq")
	private int scheduledProgramID;
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="programName")
	private ProgramsOffered programsOffered;
	private String location;
	private String startDate;
	private String endDate;
	private String sessionPerWeek;
	
	

	 
	
}

package com.cg.university.dto;

import lombok.Data;

@Data
public class ProgramsScheduledDTO {

	private String programName;
	private String location;
	private String startDate;
	private String endDate;
	private String sessionPerWeek;
	
}

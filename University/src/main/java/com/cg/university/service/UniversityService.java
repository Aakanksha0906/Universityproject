package com.cg.university.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.university.dto.ProgramsScheduledDTO;
import com.cg.university.entity.ProgramsScheduled;
import com.cg.university.repository.ProgramsOfferedRepository;
import com.cg.university.repository.ProgramsScheduledRepository;


@Service
public class UniversityService  {
	

	@Autowired
	private ProgramsScheduledRepository pgms;
	
	@Autowired
	private ProgramsOfferedRepository programsOfferedRepository;
	
	/*
	 * public boolean validatescheduledProgramID(int scheduledProgramID){
	 * ProgramsScheduled programscheduled = pgms.findOne(scheduledProgramID);
	 * if(programscheduled!= null) return true; else return false; }
	 */

   public List<ProgramsScheduled> getAllPrograms() {
		return pgms.findAll();
	}

	
	public ProgramsScheduled managePrograms(ProgramsScheduledDTO programscheduledDTO) {
		ProgramsScheduled programscheduled= new ProgramsScheduled();
		programscheduled.setEndDate(programscheduledDTO.getEndDate());
		programscheduled.setStartDate(programscheduledDTO.getStartDate());
		programscheduled.setProgramsOffered(programsOfferedRepository.getOne(programscheduledDTO.getProgramName()));
		
		
		return pgms.save(programscheduled);
	}


	public ProgramsScheduled updatePrograms(ProgramsScheduled programscheduled) {
	    return pgms.save(programscheduled);
	}


	public String deletePrograms(int scheduledProgramID) {
		//if(validatescheduledProgramID(scheduledProgramID))
		/*pgms.deleteById(scheduledProgramID);*/
		return "Program got deleted successfull";
	}


	public ProgramsScheduled getParticularProgram(String startDate, String endDate) {
		
		return null;
	}


	

}

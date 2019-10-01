package com.cg.university.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.university.dto.ProgramsScheduledDTO;
import com.cg.university.entity.Application;
import com.cg.university.entity.ProgramsOffered;
import com.cg.university.entity.ProgramsScheduled;
import com.cg.university.service.ApplicationServ;
import com.cg.university.service.ProgramsOfferedServ;
import com.cg.university.service.UniversityService;

@RestController
public class UniversityController {
	@Autowired
	private UniversityService iserv;
/****************Applicant***************/
@RequestMapping(value="/programs")	
public List<ProgramsScheduled> getAllPrograms(){
	return iserv.getAllPrograms();
}

@Autowired
private ApplicationServ applicationServ;

@RequestMapping(value="/application",method=RequestMethod.POST)
public Application apply(@RequestBody Application application) {
	return applicationServ.apply(application);

}

@RequestMapping(value="/status")
public Application getStatus(@PathVariable int applicationId) {
	return applicationServ.getStatus(applicationId);
}
/***************************MAC***************************************/

@RequestMapping(value="/getapplications")
public String getApplications(@PathVariable int scheduledProgramID) {
	return applicationServ.getApplications(scheduledProgramID);
}


@RequestMapping(value="/acceptorreject",method=RequestMethod.PUT)
public Application acceptOrReject(@RequestBody Application application) {
	return applicationServ.acceptOrReject(application);
}



@RequestMapping(value="/confirmorreject",method=RequestMethod.PUT)
public Application confirmOrReject(@RequestBody Application application) {
	return applicationServ.confirmOrReject(application);
}




/**********************Admin(managing ProgramsScheduled)****************************/
@RequestMapping(value="/add",method=RequestMethod.POST)
public ProgramsScheduled managePrograms(@RequestBody ProgramsScheduledDTO programscheduledDto) {
	
	return iserv.managePrograms(programscheduledDto);
}

@RequestMapping(value="/update",method=RequestMethod.PUT)
public ProgramsScheduled updatePrograms(@RequestBody ProgramsScheduled programscheduled) {
	return iserv.updatePrograms(programscheduled);
}

@RequestMapping(value="/delete/{scheduledProgramID}",method=RequestMethod.DELETE)
public String deletePrograms(@PathVariable int scheduledProgramID) {
	return iserv.deletePrograms(scheduledProgramID);

}
/**********************Admin(managing Offered)***************************/

@Autowired
private ProgramsOfferedServ programsOfferedServ;


@RequestMapping(value="/addprograms",method=RequestMethod.POST)
public ProgramsOffered addPrograms(@RequestBody ProgramsOffered programsOffered) {
	return programsOfferedServ.add(programsOffered);
}

@RequestMapping(value="/updateprograms",method=RequestMethod.PUT)
public ProgramsOffered update(@RequestBody ProgramsOffered programsOffered) {
	return programsOfferedServ.update(programsOffered);
}

@RequestMapping(value="/deleteprograms/{programName}",method=RequestMethod.DELETE)
public String deletePrograms(@PathVariable String programName) {
	return programsOfferedServ.delete(programName);

}

@RequestMapping(value="/getprograms")	
public List<ProgramsOffered> getPrograms(){
	return programsOfferedServ.getPrograms();
}
/***************************Admin(Report)*****************************/

@RequestMapping(value="/getapplicants/{status}/application",method=RequestMethod.GET)
public List<Application> getAllApplicants(@PathVariable String status) {
	return applicationServ.getApplicants(status);
}

public ProgramsScheduled getParticularProgram(@RequestParam String startDate,@RequestParam String endDate) {
 return iserv.getParticularProgram(startDate,endDate);

}


}

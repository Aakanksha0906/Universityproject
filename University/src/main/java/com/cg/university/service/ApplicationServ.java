package com.cg.university.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.university.entity.Application;
import com.cg.university.repository.ApplicationRep;

@Service
public class ApplicationServ {

	@Autowired
	private ApplicationRep applicationRep;
	
	public Application apply(Application application) {
		
		return applicationRep.save(application);
	}

	public Application getStatus(int applicationId) {
		applicationRep.findById(applicationId);
	  return getStatus(applicationId);
	}

	public String getApplications(int scheduledProgramID) {
		applicationRep.findById(scheduledProgramID);
		return toString();
	}

	public Application acceptOrReject(Application application) {
		return applicationRep.save(application);
	}

	public Application confirmOrReject(Application application) {
		return applicationRep.save(application);
	}

	public List<Application> getApplicants(String status) {
		return applicationRep.findByStatus(status);
	}

	

}

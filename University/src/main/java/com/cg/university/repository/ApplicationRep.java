package com.cg.university.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.university.entity.Application;

@Repository
public interface ApplicationRep extends JpaRepository<Application, Integer> {
	
	List<Application> findByStatus(String status);

}

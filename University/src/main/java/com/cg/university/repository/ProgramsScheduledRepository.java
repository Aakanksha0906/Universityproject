package com.cg.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.university.entity.ProgramsScheduled;
@Repository
public interface ProgramsScheduledRepository extends JpaRepository<ProgramsScheduled, Integer>{

	

}

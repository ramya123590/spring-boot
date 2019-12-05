package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Specialist;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialist, Integer> {
	
	 @Query(value = "SELECT speciality_name FROM speciality", nativeQuery = true)
	    public List<String> findNames();
	

} 
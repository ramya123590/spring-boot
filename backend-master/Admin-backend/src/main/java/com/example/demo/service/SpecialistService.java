package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Specialist;
import com.example.demo.exception.ResourceNotFoundException;

public interface SpecialistService {
	
	public List<Specialist> getAllSpecialist();
	
	public ResponseEntity<Specialist> getSpecialistById(Integer specialistId) throws ResourceNotFoundException;

	public Specialist createSpecialist(Specialist specialist);

	public ResponseEntity<Specialist> updateSpecialist(Integer specialistId, Specialist specialistDetails) throws ResourceNotFoundException;

	public Map<String, Boolean> deleteSpecialist(Integer specialistId) throws ResourceNotFoundException;

	public List<String> findNames();

}

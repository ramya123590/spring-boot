package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Specialist;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SpecialistRepository;

@Service
public class SpecialistServiceImpl implements SpecialistService {
	
	 @Autowired
	 private SpecialistRepository specialistRepository;
	
	@Override
	public List<Specialist> getAllSpecialist() {
		// TODO Auto-generated method stub
		return specialistRepository.findAll();
	}

	@Override
	public ResponseEntity<Specialist> getSpecialistById(Integer specialistId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Specialist specialist = specialistRepository.findById(specialistId)
		          .orElseThrow(() -> new ResourceNotFoundException("Specialist not found for this id :: " + specialistId));
		        return ResponseEntity.ok().body(specialist);
	}

	@Override
	public Specialist createSpecialist(Specialist specialist) {
		// TODO Auto-generated method stub
		return specialistRepository.save(specialist);
	}

	@Override
	public ResponseEntity<Specialist> updateSpecialist(Integer specialistId, Specialist specialistDetails)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		 Specialist specialist = specialistRepository.findById(specialistId)
			        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + specialistId));

			      
			        specialist.setSpeciality_name(specialistDetails.getSpeciality_name());
			        Specialist updatedSpecialist = specialistRepository.save(specialist);
			        return ResponseEntity.ok(updatedSpecialist);
	}

	@Override
	public Map<String, Boolean> deleteSpecialist(Integer specialistId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		  Specialist specialist = specialistRepository.findById(specialistId)
       .orElseThrow(() -> new ResourceNotFoundException("Specialist not found for this id :: " + specialistId));

        specialistRepository.delete(specialist);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
	}

	@Override
	public List<String> findNames() {
		// TODO Auto-generated method stub
		return specialistRepository.findNames();
	}

	

}

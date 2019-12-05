package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Specialist;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.SpecialistService;

@RestController
@RequestMapping("/api")
public class SpecialistController {
	
    @Autowired
    private SpecialistService specialistService;

    @GetMapping("/speciality")
    public List<Specialist> getAllSpecialists() {
        return specialistService.getAllSpecialist();
    }
    
    @GetMapping("/speciality/names")
    public List<String> getAllSpecialistNames() {
        return specialistService.findNames();
    }

    @GetMapping("/speciality/{id}")
    public ResponseEntity<Specialist> getSpecialistById(@PathVariable(value = "id") Integer specialistId)
        throws ResourceNotFoundException {
        return specialistService.getSpecialistById(specialistId);
    }
    
    @PostMapping("/speciality")
    public Specialist createSpecialist(@Valid @RequestBody Specialist specialist) {
        return specialistService.createSpecialist(specialist);
    }

    @PutMapping("/speciality/{id}")
    public ResponseEntity<Specialist> updateSpecialist(@PathVariable(value = "id") Integer specialistId,
         @Valid @RequestBody Specialist specialistDetails) throws ResourceNotFoundException {
			return specialistService.updateSpecialist(specialistId, specialistDetails);
       
     
    }

    @DeleteMapping("/speciality/{id}")
    public Map<String, Boolean> deleteSpecialist(@PathVariable(value = "id") Integer specialistId)
         throws ResourceNotFoundException {
			return specialistService.deleteSpecialist(specialistId);
       
    }
    
}
package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Login;
import com.example.demo.entity.PatientRegistration;
import com.example.demo.sevice.PatientRegistrationService;


@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class PatientRegistrationController {

    @Autowired
    private PatientRegistrationService patientRegistrationService;
    
  
    @PostMapping("/patientregister")
    public PatientRegistration create(@RequestBody PatientRegistration patient){
    
        return patientRegistrationService.savePatientRegistration(patient);
    }
    @PostMapping("/findbyuserid")
    public PatientRegistration findbyid(@RequestBody PatientRegistration login){
    
        return patientRegistrationService.getPatientbyuserid(login.getUserId());
    }

    @GetMapping(path = {"/patientregister/{id}"})
    public Optional<PatientRegistration> findOne(@PathVariable("id") int id){
        return patientRegistrationService.getPatientRegistrationById(id);
    }

    @PutMapping("/patientregister/{id}")
    public PatientRegistration update(@PathVariable("id") String id, @RequestBody PatientRegistration user){
    
        return patientRegistrationService.updatepatientregistration(id,user);
        
    }

    @DeleteMapping(path ={"/patientregister/{id}"})
    public void delete(@PathVariable("id") int id) {
         patientRegistrationService.deletePatientRegistrationById(id);
    }

    @GetMapping("/patientregister")
    public List<PatientRegistration> findAll(){
        return patientRegistrationService.getPatientRegistrations();
    }
    @PostMapping("/findbyemail")
    public PatientRegistration findLogin(@RequestBody PatientRegistration user) {
    	
       return patientRegistrationService.getPatientLogindetails(user.getEmail());
    }
    

    @PostMapping("/patientregister/validation")
    public boolean findLogin(@RequestBody Login user1){
  	  String email = user1.getUserId();
  	  String password = user1.getPassword();
  	  
  	  System.out.println(email);
  	  System.out.println(password);
     	return patientRegistrationService.checkPass(email, password);
    }
}
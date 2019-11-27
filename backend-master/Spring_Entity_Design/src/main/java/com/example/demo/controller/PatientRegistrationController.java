package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api")
public class PatientRegistrationController {

    @Autowired
    private PatientRegistrationService patientRegistrationService;
    
    private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
    @PostMapping("/patientregister")
    public PatientRegistration create(@RequestBody PatientRegistration patient){
    	
    		patient.setPassword(hashPassword(patient.getPassword()));
    		
    
    	
    	
        return patientRegistrationService.savePatientRegistration(patient);
    }

    @GetMapping(path = {"/patientregister/{id}"})
    public Optional<PatientRegistration> findOne(@PathVariable("id") int id){
        return patientRegistrationService.getPatientRegistrationById(id);
    }

    @PutMapping("/patientregister")
    public PatientRegistration update(@RequestBody PatientRegistration user){
        return patientRegistrationService.updatepatientregistration(user);
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
    
    @PostMapping("/loginvaliadtion")
    public boolean findLogin(@RequestBody Login login){
    	System.out.println(login.getUserId());
    	System.out.println(login.getPassword());
        boolean s= patientRegistrationService.checkPass(login.getUserId(), login.getPassword());
        System.out.println(s);
        return s;
    }
}
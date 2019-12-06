package com.example.demo.sevice;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.PatientRegistration;

public interface PatientRegistrationService {
	
	public List<PatientRegistration> getPatientRegistrations();

	public PatientRegistration savePatientRegistration(PatientRegistration thePatientRegistration);

	public  Optional<PatientRegistration> getPatientRegistrationById(int theId);

	public void deletePatientRegistrationById(int theId);

	public PatientRegistration updatepatientregistration(String id, PatientRegistration patient);
	
	public PatientRegistration getPatientLogindetails(String userid);
	public boolean checkPass(String userid, String password) ;
	public PatientRegistration getPatientbyuserid(String userid);
	
	public void getResetlink(String email);
	public PatientRegistration setResetPassword(PatientRegistration thePatientRegistration);

}




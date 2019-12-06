package com.example.demo.sevice;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PatientRegistration;
import com.example.demo.repository.PatientRegistrationRepository;

@Service
public class PatientRegistrationServiceImpl implements PatientRegistrationService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	PatientRegistrationRepository patientRegistrationrepository;

	@Override
	@Transactional
	public List<PatientRegistration> getPatientRegistrations() {
		// TODO Auto-generated method stub
		return patientRegistrationrepository.findAll();
	}

	@Override
	@Transactional
	public PatientRegistration savePatientRegistration(PatientRegistration thePatientRegistration) {
		// TODO Auto-generated method stub
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 6) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		thePatientRegistration.setUserId(saltStr);
		// theuser.setPid(saltStr);
		System.out.print("saltStr");
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(thePatientRegistration.getEmail());
		
		mail.setSubject("Patient Id");
		mail.setText("Dear "+thePatientRegistration.getFirstName()+"\n Your Account has been registered with patient Id: "+saltStr+"\nThank You");
		
		javaMailSender.send(mail);
		
		

	
	   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       String newPassword = passwordEncoder.encode(thePatientRegistration.getPassword());
       thePatientRegistration.setPassword(newPassword);
		return patientRegistrationrepository.save(thePatientRegistration);
		
	}


	@Override
	@Transactional
	public Optional<PatientRegistration> getPatientRegistrationById(int theId) {
		// TODO Auto-generated method stub

		return patientRegistrationrepository.findById(theId);
	}

	@Override
	@Transactional
	public void deletePatientRegistrationById(int theId) {
		// TODO Auto-generated method stub
		Optional<PatientRegistration> patient = getPatientRegistrationById(theId);
		if (patient != null) {
			patientRegistrationrepository.deleteById(theId);
		}

	}

	@Override
	public PatientRegistration updatepatientregistration(String id, PatientRegistration patient) {
		// TODO Auto-generated method stub
		PatientRegistration patientupdate=getPatientbyuserid(id);
		patientupdate.setFirstName(patient.getFirstName());
		patientupdate.setEmail(patient.getEmail());
		patientupdate.setCity(patient.getCity());
		patientupdate.setDateofbirth(patient.getDateofbirth());
		patientupdate.setPhone(patient.getPhone());
		return   patientRegistrationrepository.save(patientupdate);
		
	}

	@Override
	public PatientRegistration getPatientLogindetails(String email) {
		// TODO Auto-generated method stub
		return patientRegistrationrepository.findByEmail(email);

	}

	@Override
	public boolean checkPass(String userid, String password)
	{
		boolean result = false;
		System.out.print(getPatientbyuserid( userid));
		PatientRegistration patientregistration = getPatientbyuserid( userid);
		if(patientregistration!=null)
		{
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
	    	
			System.out.println("p" + password);
			System.out.println("q" + patientregistration.getPassword());
		
			if(encoder.matches(password, patientregistration.getPassword()))
	    	{
	    		 result = true;
	    	}
	    	else
	    	{
	    		 result = false;
	    	}	
		}
		return result;	
	}	



	@Override
	public PatientRegistration getPatientbyuserid(String userid) {
		// TODO Auto-generated method stub
		return patientRegistrationrepository.findByUserId(userid);
	}
	
	public void getResetlink(String email)
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		
			mail.setTo(email);
			mail.setSubject("Reset Password");
			mail.setText("To complete the password reset process, please click here: http://localhost:4200/resetPassword ");
			javaMailSender.send(mail);
		
		
		
	}

	@Override
	public PatientRegistration setResetPassword(PatientRegistration thePatientRegistration) {
		// TODO Auto-generated method stub
		PatientRegistration password =patientRegistrationrepository.findByEmail(thePatientRegistration.getEmail());
		System.out.println(password);
			   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		       String newPassword = passwordEncoder.encode(thePatientRegistration.getPassword());
		       password.setPassword(newPassword);
				return patientRegistrationrepository.save(password);
				}


}
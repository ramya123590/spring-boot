package com.example.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Appointmodel;
import com.example.demo.entity.DoctorRegistration;
import com.example.demo.entity.PatientRegistration;
import com.example.demo.sevice.AppointmentService;
import com.example.demo.sevice.DoctorRegistrationService;
import com.example.demo.sevice.PatientRegistrationService;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientRegistrationService patientRegistrationService;
    @Autowired
    private DoctorRegistrationService doctorRegistrationService;
    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/appointments")
    public String notavailable(@RequestBody Appointmodel appointment){
    	System.out.println(appointment.getDoctor_id());
    	DoctorRegistration doctorregistration=doctorRegistrationService.findbydoctorid(appointment.getDoctor_id());
    
    	List<Appointment> app=appointmentService.findbydoctoranddate(doctorregistration,appointment.getDate() );
    	System.out.println(doctorregistration);
    	System.out.println("helloo");
    	System.out.println(app);
    	for(Appointment temp: app){
    		System.out.println("hel"+temp.getPatientregistration());
    		
    		SimpleMailMessage mail = new SimpleMailMessage();
    		mail.setTo(temp.getPatientregistration().getEmail());
        	
    		mail.setSubject("Appointment details");
    		mail.setText("Hi "+temp.getPatientregistration().getFirstName()+"\n date"+temp.getDate()+"\n time:"+temp.getSlot()+" canceled");

    		javaMailSender.send(mail);
    		System.out.println("app:"+temp.getId());
    		appointmentService.deleteAppointmentById(temp.getId());
    	}
    	
    	return "hello" ;
   
    }

	@PostMapping("/appointment")
    public Appointment create(@RequestBody Appointmodel appointment){
    	PatientRegistration patientregistraion=patientRegistrationService.getPatientbyuserid(appointment.getPatient_id());
    	DoctorRegistration doctorregistration=doctorRegistrationService.findbydoctorid(appointment.getDoctor_id());
    	
    	
 
    	
		SimpleMailMessage mail = new SimpleMailMessage();
	System.out.println(patientregistraion.getEmail());
	
    	System.out.println("sent");
    	
    	Appointment app=new Appointment();
    	app.setPatientregistration(patientregistraion);
    	app.setDoctorregistration(doctorregistration);
    	app.setDate(appointment.getDate());
    	app.setSlot(appointment.getSlot());
    	app.setIsfeepaid(appointment.isIsfeepaid());
    	System.out.println(app);
    	mail.setTo(patientregistraion.getEmail());
    	
		mail.setSubject("Appointment details");
		mail.setText("hi"+patientregistraion.getFirstName()+"\ndate"+app.getDate()+"\ntime:"+app.getSlot()+"Kindly visit");

		javaMailSender.send(mail);
        return appointmentService.saveAppointment(app);
    }
    

    @GetMapping(path = {"/appointment/{id}"})
    public Optional<Appointment> findOne(@PathVariable("id") int id){
        return appointmentService.getAppointmentById(id);
    }

    @PutMapping("/appointment/{id}")
    public Appointment update(@PathVariable("id") String id, @RequestBody Appointment appointment){
        return appointmentService.updatepatientregistration(appointment);
    }

    @DeleteMapping(path ={"/appointment/{id}"})
    public void delete(@PathVariable("id") int id) {
         appointmentService.deleteAppointmentById(id);
       
    }

    @GetMapping("/appointment")
    public List<Appointment> findAll(){
        return appointmentService.getAppointments();
    }
    @PostMapping("/find")
    public boolean findbydoctorandslot(@RequestBody Appointmodel appointment) {
    	DoctorRegistration doctorregistration=doctorRegistrationService.findbydoctorid(appointment.getDoctor_id());

    	Appointment app=appointmentService.findbydoctorandslot(doctorregistration,appointment.getSlot(),appointment.getDate());
    	System.out.println("date"+appointment.getDate());
    	System.out.println(app);
    	boolean result;
    	if(app!=null) {
    		result=true;
    	}
    	else {
    		result=false;
    	}
    	return result;
    	
    	
    }
    @PostMapping("/appointment_details")
    public List<Appointment> getdetails(@RequestBody Appointmodel appointment) {
    	PatientRegistration patientregistraion=patientRegistrationService.getPatientbyuserid(appointment.getPatient_id());
    	System.out.println(patientregistraion);
    	System.out.println("hello");
    	  List<Appointment> app=appointmentService.findbypatient(patientregistraion);
    	System.out.println(app);
    	  return app;
    	
    }
    	
    
}
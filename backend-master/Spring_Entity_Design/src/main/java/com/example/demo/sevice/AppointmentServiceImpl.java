package com.example.demo.sevice;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.DoctorRegistration;
import com.example.demo.entity.PatientRegistration;
import com.example.demo.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentRepository Appointmentrepository;

	@Override
	@Transactional
	public List<Appointment> getAppointments() {
		// TODO Auto-generated method stub
		return Appointmentrepository.findAll();
	}

	@Override
	@Transactional
	public Appointment saveAppointment(Appointment theAppointment) {
		// TODO Auto-generated method stub
		return Appointmentrepository.save(theAppointment);
		
	}

	@Override
	@Transactional
	public Optional<Appointment> getAppointmentById(int theId) {
		// TODO Auto-generated method stub
		
		return Appointmentrepository.findById(theId);
	}

	@Override
	@Transactional
	public void deleteAppointmentById(int theId) {
		// TODO Auto-generated method stub
		Optional<Appointment> appointment =  getAppointmentById(theId);
        if(appointment  != null){
        	Appointmentrepository.deleteById(theId);
        }
		
		
	}

	@Override
	public Appointment updatepatientregistration(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Appointment findbydoctorandslot(DoctorRegistration doctor, String slot,Date date) {
		// TODO Auto-generated method stub
		return Appointmentrepository.findBySlotAndDateAndDoctorregistration(slot,date, doctor);
	}

	@Override
	public List<Appointment> findbypatient(PatientRegistration patient) {
		// TODO Auto-generated method stub
		return Appointmentrepository.findByPatientregistration(patient);
	}

	@Override
	public List<Appointment> findbydoctoranddate(DoctorRegistration doctor, Date date) {
		// TODO Auto-generated method stub
		return Appointmentrepository.findByDateAndDoctorregistration(date, doctor);
	}

	

}
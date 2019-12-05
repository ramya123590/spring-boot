package com.example.demo.sevice;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.DoctorRegistration;
import com.example.demo.entity.PatientRegistration;

public interface AppointmentService {
	
	public List<Appointment> getAppointments();

	public Appointment  saveAppointment(Appointment theAppointment);

	public   Optional<Appointment> getAppointmentById(int theId);

	public void deleteAppointmentById(int theId);

	public Appointment updatepatientregistration(Appointment appointment);


	Appointment findbydoctorandslot(DoctorRegistration doctor, String slot,Date date);
	List<Appointment> findbypatient(PatientRegistration patient);
	List<Appointment> findbydoctoranddate(DoctorRegistration doctor, Date date);

}

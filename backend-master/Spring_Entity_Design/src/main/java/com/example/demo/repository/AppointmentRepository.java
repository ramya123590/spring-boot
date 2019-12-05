package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.DoctorRegistration;
import com.example.demo.entity.PatientRegistration;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	 //@Query("select a from Appointment a where doctor_id=?1 and slot=?2")
	Appointment findBySlotAndDateAndDoctorregistration(String time,Date date,DoctorRegistration doctor) ;
	List<Appointment> findByPatientregistration(PatientRegistration patient) ;
	List<Appointment> findByDateAndDoctorregistration(Date date,DoctorRegistration doctor) ;
}


package com.example.demo.entity;

import java.sql.Blob;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "appointment")
@AllArgsConstructor
@NoArgsConstructor

@Setter
@Getter


public class Appointment {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "date")
	private Date date;
	@Column(name = "slot")
	private String slot;
	
	@Column(name = "isfeepaid")
	private boolean isfeepaid;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name = "patient_id")
	private PatientRegistration patientregistration;
	/*
	 * @JsonCreator public patientRegistration (@JsonProperty("") Integer flight_id
	 * ) { this.flight_id = flight_id; }
	 */

	

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name = "doctor_id")
	private DoctorRegistration doctorregistration;

	
	

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + date + ", slot=" + slot + ", isfeepaid=" + isfeepaid
				+ ", patientregistration=" + patientregistration + ", doctorregistration=" + doctorregistration + "]";
	}
	
	

}
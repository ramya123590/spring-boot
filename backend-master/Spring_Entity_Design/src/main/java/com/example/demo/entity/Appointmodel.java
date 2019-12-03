package com.example.demo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointmodel {

private int id;
	
	
	private Date date;

	private String slot;
	
	private boolean isfeepaid;
	private String patient_id;
	private int doctor_id;

}

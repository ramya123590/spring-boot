package com.example.demo.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "patientregistration")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PatientRegistration {
	@ApiModelProperty(notes = "Patient Id",name="patient_id",required=true,value="test name")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patient_id;
	@ApiModelProperty(notes = "User Id",name="userId",required=true,value="test name")
	@Column(name = "userId" ,unique= true)
	private String userId;
	@ApiModelProperty(notes = "First Name",name="firstName",required=true,value="test name")
	@Column(name = "first_name")
	private String firstName;
	@ApiModelProperty(notes = "Middle Name",name="middleNam",required=true,value="test name")
	@Column(name = "middle_name")
	private String middleName;
	@ApiModelProperty(notes = "Last Name",name="lastName",required=true,value="test name")
	@Column(name = "last_name")
	private String lastName;
	@ApiModelProperty(notes = "Email",name="email",required=true,value="test name")
	@Column(name = "email" ,unique= true)
	private String email;
	@ApiModelProperty(notes = "Date of birth",name="dateofbirth",required=true,value="test name")
	@Column(name = "date_of_birth")
	private Date dateofbirth;
	@ApiModelProperty(notes="age",name="age",required=true,value="test name")
	@Column(name = "age")
	private int age;
	@ApiModelProperty(notes = "Gender",name="gender",required=true,value="test name")
	@Column(name = "gender")
	private String gender;
	@ApiModelProperty(notes = "Address",name="Address",required=true,value="test name")
	@Column(name = "Adress")
	private String Address;
	@ApiModelProperty(notes = "City",name="state",required=true,value="test name")
	@Column(name = "city")
	private String city;
	@ApiModelProperty(notes = "State",name="state",required=true,value="test name")
	@Column(name = "state")
	private String state;
	@ApiModelProperty(notes = "Pincode",name="pincode",required=true,value="test name")
	@Column(name = "pincode")
	private int pincode;
	@ApiModelProperty(notes = "Phone",name="phone",required=true,value="test name")
	@Column(name = "phone")
	private Long phone;
	@ApiModelProperty(notes = "Password",name="password",required=true,value="test name")
	private String password;

	

}
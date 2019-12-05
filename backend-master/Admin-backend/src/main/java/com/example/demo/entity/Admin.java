package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	Integer id ;
	
	@Column(name = "username")
	String adminUserName;
	
	@Column(name = "password")
	String admin_password;

	public Admin(String admin_userName, String admin_password) {
		super();
		this.adminUserName = admin_userName;
		this.admin_password = admin_password;
	}

	
	
	
}

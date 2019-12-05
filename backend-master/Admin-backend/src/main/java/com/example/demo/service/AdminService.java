package com.example.demo.service;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Admin;
import com.example.demo.exception.ResourceNotFoundException;

public interface AdminService {

	List<Admin> getAllAdmin();

	ResponseEntity<Admin> getAdminById(Integer adminId) throws ResourceNotFoundException;

	Admin createAdmin(Admin Admin);

	ResponseEntity<Admin> updateAdmin(Integer adminId, Admin adminDetails) throws ResourceNotFoundException;

	Map<String, Boolean> deleteAdmin(Integer adminId) throws ResourceNotFoundException;

	boolean checkPass(String email, String password);

	public	Admin getAdminByUsername(String email);
	
	
}

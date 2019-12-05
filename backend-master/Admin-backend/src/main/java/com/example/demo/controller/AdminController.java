package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Login;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.AdminService;


@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmin();
    }

    @GetMapping("/admins/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable(value = "id") Integer adminId)
        throws ResourceNotFoundException {    
        return adminService.getAdminById(adminId);
    }
    
    @PostMapping("/admins")
    public Admin createAdmin(@Valid @RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @PutMapping("/admins/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable(value = "id") Integer adminId,
         @Valid @RequestBody Admin adminDetails) throws ResourceNotFoundException {
      return adminService.updateAdmin(adminId, adminDetails);
    }

    @DeleteMapping("/admins/{id}")
    public Map<String, Boolean> deleteAdmin(@PathVariable(value = "id") Integer adminId)
         throws ResourceNotFoundException {     
        return adminService.deleteAdmin(adminId);
    }
    
    @PostMapping("/admins/validation")
    public boolean loginValidation(@RequestBody Login user1){
    	System.out.println("hello"+user1);
    	
  	  String email = user1.getUserId();
  	  System.out.println(email);
  	  String password = user1.getPassword();
     	return adminService.checkPass(email, password);
    }
    
   
}
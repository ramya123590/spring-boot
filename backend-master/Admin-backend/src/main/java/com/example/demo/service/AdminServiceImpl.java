package com.example.demo.service;
 import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Admin;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AdminRepository;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
    private AdminRepository adminRepository;
	
	  
		@Override
		@Transactional
	    public List<Admin> getAllAdmin() {
	        return adminRepository.findAll();
	    }

	   
		@Override
		@Transactional
	    public ResponseEntity<Admin> getAdminById(Integer adminId) throws ResourceNotFoundException
	    {
	    	Admin admin = adminRepository.findById(adminId)
	          .orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));
	        return ResponseEntity.ok().body(admin);
	    }
	    
		@Override
		@Transactional
	    public Admin createAdmin(Admin admin) 
	    {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String newPassword = passwordEncoder.encode(admin.getAdmin_password());
	        admin.setAdmin_password(newPassword);
	        return adminRepository.save(admin);
	    }

		@Override
		@Transactional
	    public ResponseEntity<Admin> updateAdmin(Integer adminId, Admin adminDetails) throws ResourceNotFoundException
	    {
	        Admin admin = adminRepository.findById(adminId)
	        .orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));

	        admin.setAdminUserName(adminDetails.getAdminUserName());
	        admin.setAdmin_password(adminDetails.getAdmin_password());
	        Admin updatedAdmin = adminRepository.save(admin);
	        return ResponseEntity.ok(updatedAdmin);
	    }

	    
		@Override
		@Transactional
	    public Map<String, Boolean> deleteAdmin(Integer adminId) throws ResourceNotFoundException {

	        Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));
	        adminRepository.delete(admin);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
		
		@Override
		@Transactional
		public Admin getAdminByUsername(String email) {
			// TODO Auto-generated method stub
			return adminRepository.findByAdminUserName(email);
		}
		
		
		@Override
		public boolean checkPass(String email, String password)
		{
			boolean result = false;
			System.out.println(email);
			Admin admin = getAdminByUsername( email);
			System.out.println(admin);
			if(admin!=null)
			{
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		    	
			
			
				if(encoder.matches(password, admin.getAdmin_password()))
		    	{
		    		 result = true;
		    	}
		    	else
		    	{
		    		 result = false;
		    	}	
			}
			return result;	
		}

		
}
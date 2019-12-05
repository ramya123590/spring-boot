package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import com.example.demo.entity.Branch;
import com.example.demo.exception.ResourceNotFoundException;

public interface BranchService {
	
	public List<Branch> getAllBranch();
	
	public ResponseEntity<Branch> getBranchById(Integer branchId) throws ResourceNotFoundException;

	public Branch createBranch(Branch branch);

	public ResponseEntity<Branch> updateBranch(Integer branchId, Branch branchDetails) throws ResourceNotFoundException;

	public Map<String, Boolean> deleteBranch(Integer branchId) throws ResourceNotFoundException;

	public List<String> findNames();

}

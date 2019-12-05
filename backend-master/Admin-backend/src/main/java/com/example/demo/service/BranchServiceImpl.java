package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Branch;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Override
	@Transactional
	public List<Branch> getAllBranch() {
		// TODO Auto-generated method stub
		return branchRepository.findAll();
	}


	@Override
	public ResponseEntity<Branch> getBranchById(Integer branchId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Branch branch = branchRepository.findById(branchId)
		          .orElseThrow(() -> new ResourceNotFoundException("Branch not found for this id :: " + branchId));
		        return ResponseEntity.ok().body(branch);
	}

	@Override
	public Branch createBranch(Branch branch) {
		// TODO Auto-generated method stub
		return branchRepository.save(branch);
	}

	@Override
	public ResponseEntity<Branch> updateBranch(Integer branchId, Branch branchDetails)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		 Branch branch = branchRepository.findById(branchId)
			        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + branchId));

			      
			        branch.setBranchName(branchDetails.getBranchName());
			        Branch updatedBranch = branchRepository.save(branch);
			        return ResponseEntity.ok(updatedBranch);
	}

	@Override
	public Map<String, Boolean> deleteBranch(Integer branchId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		 Branch branch = branchRepository.findById(branchId)
			       .orElseThrow(() -> new ResourceNotFoundException("Branch not found for this id :: " + branchId));

			        branchRepository.delete(branch);
			        Map<String, Boolean> response = new HashMap<>();
			        response.put("deleted", Boolean.TRUE);
			        return response;
	}

	@Override
	public List<String> findNames() {
		// TODO Auto-generated method stub
		return branchRepository.findNames();
	}

}

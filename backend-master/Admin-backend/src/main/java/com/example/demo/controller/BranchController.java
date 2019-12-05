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

import com.example.demo.entity.Branch;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.BranchService;

@RestController
@RequestMapping("/api")
public class BranchController {
	
    @Autowired
    private BranchService branchService;

    @GetMapping("/branch")
    public List<Branch> getAllBranchs() {
        return branchService.getAllBranch();
    }
    
    @GetMapping("/branch/names")
    public List<String> getAllBranchNames() {
        return branchService.findNames();
    }

    @GetMapping("/branch/{id}")
    public ResponseEntity<Branch> getBranchById(@PathVariable(value = "id") Integer branchId)
        throws ResourceNotFoundException {
        return branchService.getBranchById(branchId);
    }
    
    @PostMapping("/branch")
    public Branch createBranch(@Valid @RequestBody Branch branch) {
        return branchService.createBranch(branch);
    }

    @PutMapping("/branch/{id}")
    public ResponseEntity<Branch> updateBranch(@PathVariable(value = "id") Integer branchId,
         @Valid @RequestBody Branch branchDetails) throws ResourceNotFoundException {
			return branchService.updateBranch(branchId, branchDetails);
       
     
    }

    @DeleteMapping("/branch/{id}")
    public Map<String, Boolean> deleteBranch(@PathVariable(value = "id") Integer branchid)
         throws ResourceNotFoundException {
			return branchService.deleteBranch(branchid);
       
    }
    
}
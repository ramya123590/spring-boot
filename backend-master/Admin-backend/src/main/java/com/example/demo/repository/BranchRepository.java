package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
	
	 @Query(value = "SELECT branch_name FROM branch", nativeQuery = true)
	    public List<String> findNames();
	

} 
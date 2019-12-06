package com.mynotes.spring.cloud.feign;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class IntegrationClient {

	@Autowired
	private SpecialityService specialist;



	public Collection<Specialist> getspecialistFallback() {
		System.out.println("===========getOffersFallback===========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getspecialistFallback")
	public Collection<Specialist> getspecialist() {
		return this.specialist.getAllSpecialists();
	}
	
	public Collection<Specialist> postOffersFallback() {
		System.out.println("===========getOffersFallback===========");
		return Arrays.asList();
	}
	
	@HystrixCommand(fallbackMethod = "postOffersFallback")
	public void postspecialist(Specialist specialist) {
		// TODO Auto-generated method stub
		this.specialist.createSpecialist(specialist);
		
	}
	
	

}

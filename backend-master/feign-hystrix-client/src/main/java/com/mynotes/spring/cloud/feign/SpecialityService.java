package com.mynotes.spring.cloud.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("specialist-service")
public interface SpecialityService {

    @RequestMapping(value = "/api/speciality", method = RequestMethod.GET)
    public List<Specialist> getAllSpecialists();

    
    @RequestMapping(value = "/api/speciality", method = RequestMethod.POST)
    public Specialist createSpecialist(Specialist specialist);

}
package com.example.demo.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import com.example.demo.AdminBackendApplication;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;






@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AdminBackendApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpecialistControllerTest {
	
	
	@Autowired
	private  Environment env;
	private MockMvc mockMvc;
	org.slf4j.Logger log=LoggerFactory.getLogger(SpecialistControllerTest.class);
	@Autowired
    private WebApplicationContext wac;
	
	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        log.info("context loaded sucessfully... Listening on port: "+env.getProperty("server.port"));
	}
	
//	@Test
//    public void shouldReturnDefaultMessage() throws Exception {
//        this.mockMvc.perform(get("/").header("Origin","*")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello World")));
//    }

	
	@Test
	public void findSpeciality() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/speciality").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(5))).andDo(print());
		//has size- no of records in db
	}
	
	
	
	@Test
	public void retrieveSpecialistNames() throws Exception {
	
		RequestBuilder request = MockMvcRequestBuilders
				.get("/api/speciality/names")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[\"Cardiologist\",\"Dental\",\"ENT\",\"Eye\",\"Gynacology\"]"))
				.andReturn();
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}
	
	


}

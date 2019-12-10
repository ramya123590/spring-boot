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
public class BranchControllerTests {
	
	
	@Autowired
	private  Environment env;
	private MockMvc mockMvc;
	org.slf4j.Logger log=LoggerFactory.getLogger(BranchControllerTests.class);
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
	public void findBranch() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/branch").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(2))).andDo(print());
	}
	
	@Test
	public void findBranchById() throws Exception {
	 	mockMvc.perform(MockMvcRequestBuilders.get("/api/branch/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.bid").exists())
		.andExpect(jsonPath("$.branchName").exists())
		//.andExpect(jsonPath("$.completed").value(false))
		.andDo(print());
	}
	
	@Test
	public void retrieveBranchNames() throws Exception {
	
		RequestBuilder request = MockMvcRequestBuilders
				.get("/api/branch/names")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[\"Hebbal\",\"Nagavara\"]"))
				.andReturn();
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}
	
	


}

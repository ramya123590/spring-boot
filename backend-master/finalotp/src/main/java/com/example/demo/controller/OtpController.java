package com.example.demo.controller;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.User;
import com.example.demo.service.NotificationService;


@RestController
public class OtpController 
{
	private JavaMailSender javaMailSender;
	public OtpController(JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}
	//private Logger logger = LoggerFactory.getLogger(OtpController.class);
	
	@Autowired
	private NotificationService notificationService;
	
	
	@GetMapping("/otp")
	public List<User> findall()
	{
		return notificationService.getall();
	}
	 @PostMapping("/findbyemail")
	    public User findLogin(@RequestBody User user) {
	    	
	       return notificationService.findbyemail( user.getEmail());
	    }
	    
	
	/*
	 * @RequestMapping("/signup") public String signup() { return
	 * "Please sign up for our service"; }
	 */

	/*
	 * @RequestMapping("/") public void home(Model theModel) { User theUser=new
	 * User(); theModel.addAttribute("employee",theUser); //return "form1"; }
	 */
	@PostMapping("/otp")
	public void signupSuccess(@RequestBody  User theuser )
	{
	
		
			notificationService.Sendnotification(theuser);
		
		//theModel.addAttribute("employee",theuser);
		//return "form";
	}
	
	/*
	 * @RequestMapping(value="/validate", method=RequestMethod.POST) public void
	 * validate(@RequestBody User theuser ) {
	 * 
	 * 
	 * 
	 * notificationService.Validate(theuser);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	}

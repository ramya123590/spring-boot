package com.example.demo.controller;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.NotificationService;


@Controller
public class OtpController 
{
	/*
	 * private JavaMailSender javaMailSender; public OtpController(JavaMailSender
	 * javaMailSender) { super(); this.javaMailSender = javaMailSender; }
	 */
	private Logger logger = LoggerFactory.getLogger(OtpController.class);
	
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping("/")
	public String home(Model theModel)
	{
		User theUser=new User();
		theModel.addAttribute("user",theUser);
		return "form1";
	}
	
	@RequestMapping(value="/generateId", method=RequestMethod.POST)
	public String signupSuccess(@ModelAttribute("form1") @Valid User theuser , BindingResult result,Model theModel)
	{
	
		
		
		try
		{
			notificationService.GeneratePatientid(theuser);
		}
		catch(MailException e)
		{
			logger.info("Error generating pateint id");
		}
		theModel.addAttribute("user",theuser);
		return "form";
	}
	@RequestMapping("/validate")
	public String validate(Model theModel)
	{
		
		return "succes";
	}
}

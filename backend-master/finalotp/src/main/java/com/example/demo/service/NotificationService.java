package com.example.demo.service;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;

@Service
public class NotificationService 
{
	private JavaMailSender javaMailSender;
	
	@Autowired
UserRepository userRepository;
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) 
	{
		super();
		this.javaMailSender = javaMailSender;
	}
	public List<User> getall(){
		return userRepository.findAll();
	}
	public User findbyemail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public void Sendnotification(User theuser) 
	{
		String user1=theuser.getEmail();
		theuser.setEmail(user1);
		Random rand = new Random();
		String id = String.format("%04d", rand.nextInt(10000));
		SimpleMailMessage mail = new SimpleMailMessage();
		
		//user.setOtp(id);
		System.out.println("hai"+id);
		mail.setTo(theuser.getEmail());
		//mail.setFrom("ramyaskv812@gmail.com");
		mail.setSubject(id);
		mail.setText("otp");
		theuser.setOtp(id);
		javaMailSender.send(mail);
		userRepository.save(theuser);
		
	}	
	  public void Validate(User theuser)  {
		 
	
		  if(theuser.getOtp().equals(theuser.getOtp1())) {
				System.out.println("valid");
			}
			else {
				System.out.println("invalid");
			}
		  
}
}
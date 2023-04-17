package com.hubino.marksheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hubino.marksheet.entity.AuthRequest;
import com.hubino.marksheet.utility.JwtUtil;

@RestController
public class UserController {
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	@GetMapping("/homepage")
	public String homePage()
	{
		return "Welcome To Hubino HomePage";
	}
	
	@PostMapping("/authentication")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception
	{
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		return util.generateToken(authRequest.getUsername());
		}
		catch (Exception e) {
			throw new Exception("Invalid Credentials");
		}
	}

}

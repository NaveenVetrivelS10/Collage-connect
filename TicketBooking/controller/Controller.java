package com.example.TicketBooking.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketBooking.dto.TicketBookingDTO;
import com.example.TicketBooking.entity.MovieDetialsEntity;
import com.example.TicketBooking.entity.TheatersDetailsEntity;
import com.example.TicketBooking.model.JwtRequest;
import com.example.TicketBooking.model.JwtResponse;
import com.example.TicketBooking.service.TaskService;
import com.example.TicketBooking.service.UsersDetailService;
import com.example.TicketBooking.utility.JWTUtility;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

@RestController

public class Controller

{

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private TaskService taskService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UsersDetailService usersDetailService;

	@GetMapping("/Gettheaters")
	public List<TheatersDetailsEntity> showTheaters() 
	{
		return taskService.showTheaters();
	}

	@GetMapping("/getTheaterByLocationName/{place}")
	public List<TheatersDetailsEntity> theaterByLocationName(@PathVariable String place) {
		return taskService.theaterByLocationName(place);
	}

	@GetMapping("/Getmovies")
	public List<MovieDetialsEntity> showMovies() {
		return taskService.showMovies();
	}
	
	@PostMapping("/BookTickets")
	public String bookTicket(@RequestBody TicketBookingDTO tbDTO) 
	{
		boolean status = taskService.bookTicket(tbDTO);
		if (status) 
		{
			return "Seat is Available make payment for confirmation,please do the payment using this url http://localhost:8080/";
		} else {
			return "The seat is already booked";
		}
	}
	@GetMapping("/homepage")
	public String homepage() 
	{
		return "WelcomeToMovieBooking";
	}
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception 
	{
		UserDetails userDetails = usersDetailService.loadUserByUsername(jwtRequest.getUsername());

		if (userDetails != null) 
		{
			String token = jwtUtility.generateToken(userDetails);
			return new JwtResponse(token);
		}else 
		{
			return new JwtResponse("Invalidusername");
		}

	}
}
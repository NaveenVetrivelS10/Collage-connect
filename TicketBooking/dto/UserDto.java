package com.example.TicketBooking.dto;

import com.example.TicketBooking.entity.MovieDetialsEntity;

import lombok.Data;



@Data
public class UserDto 
{
	private Integer id;
	private String name;
	private String email;
	private String password;
}

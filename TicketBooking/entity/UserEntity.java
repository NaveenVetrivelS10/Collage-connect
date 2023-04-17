package com.example.TicketBooking.entity;







import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "user_info")
@Entity

public class UserEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Integer id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	
	
	
   
	
	
	
}
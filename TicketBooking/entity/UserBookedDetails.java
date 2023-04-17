package com.example.TicketBooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;




@Data
@Table(name = "ticket_booking_details")
@Entity
public class UserBookedDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer ticketid;
	
	@Column
	private Integer movie_id;
	
	@Column
	private Integer theater_id;
	
	@Column
	private Integer seatNumber;
}

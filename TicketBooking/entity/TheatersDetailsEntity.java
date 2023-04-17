package com.example.TicketBooking.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity

@Data
@Table(name = "theater")
public class TheatersDetailsEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer theater_id;
	@Column
	private String theaterName;
	@Column
	private String place;
	@Column
	private String totalscreens;
}

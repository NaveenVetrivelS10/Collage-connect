package com.example.TicketBooking.entity;









import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@javax.persistence.Entity
@Data
@javax.persistence.Table(name = "screen")

public class ScreenDetailsEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private String screenName;
	@OneToOne
	@JoinColumn
	private  MovieDetialsEntity movieDetials;
	
	@ManyToOne
	@JoinColumn
	private  TheatersDetailsEntity theatersDetails;
	
}
  
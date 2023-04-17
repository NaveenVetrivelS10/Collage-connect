package com.example.TicketBooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;



@Entity

@Data
@Table(name = "seat")
public class SeatDetailsEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private String rowName;
	@Column
	private String coulmnName;
	@Column
	private String status;
	
	
	@ManyToOne
	@JoinColumn
	private ScreenDetailsEntity screen;
}



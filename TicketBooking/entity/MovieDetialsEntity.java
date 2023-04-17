package com.example.TicketBooking.entity;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Data
@Table(name = "movie")
@Entity

public class MovieDetialsEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer movie_id;
	
	@Column
	private String Language;
	@Column
	private String Format;
	@Column
	private String movieName;
	@Column
	private String genres;
	@Column
	private String length;
	@Column
	private String ticketrate;
	
}

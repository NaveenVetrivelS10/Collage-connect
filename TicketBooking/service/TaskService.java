package com.example.TicketBooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TicketBooking.dto.TicketBookingDTO;
import com.example.TicketBooking.entity.MovieDetialsEntity;
import com.example.TicketBooking.entity.SeatDetailsEntity;
import com.example.TicketBooking.entity.TheatersDetailsEntity;
import com.example.TicketBooking.entity.UserBookedDetails;
import com.example.TicketBooking.repository.MovieDetialsRepository;
import com.example.TicketBooking.repository.SeatDetailsRepository;
import com.example.TicketBooking.repository.TheatersDetailsRepository;
import com.example.TicketBooking.repository.UserBookedDetailsRepo;

@Service("taskService")
public class TaskService {
	@Autowired
	private MovieDetialsRepository movieDetialsRepository;

	@Autowired
	private TheatersDetailsRepository theatersDetailsRepository;

	@Autowired
	private UserBookedDetailsRepo userTicketRepo;

	@Autowired
	private SeatDetailsRepository seatDetailsRepository;

	public List<TheatersDetailsEntity> theaterByLocationName(String place) {
		return theatersDetailsRepository.findByPlace(place);
	}
	public List<TheatersDetailsEntity> showTheaters() 
	{
		return theatersDetailsRepository.findAll();
	}
	public List<MovieDetialsEntity> showMovies() 
	{
		return movieDetialsRepository.findAll();
	}
	public  boolean  bookTicket(TicketBookingDTO tbDTO) {
		//String message;
		SeatDetailsEntity seatDetailsEntity = seatDetailsRepository.findById(tbDTO.getSeats()).get();
		String status = seatDetailsEntity.getStatus();
		if (status.equalsIgnoreCase("Booked")) 
		{
		return false;  //message="The seat is already booked";
		} else 
		{
			UserBookedDetails entity = new UserBookedDetails();
			entity.setMovie_id(tbDTO.getMovie_id());
			entity.setTheater_id(tbDTO.getTheater_id());
			entity.setSeatNumber(tbDTO.getSeats());
			userTicketRepo.save(entity);
			seatDetailsEntity.setStatus("Booked");
			seatDetailsRepository.save(seatDetailsEntity);
			return true;// message="Ticket Booked Successfully";
		}

	}

	
}

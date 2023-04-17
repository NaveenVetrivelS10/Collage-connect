package com.example.TicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TicketBooking.entity.SeatDetailsEntity;

public interface SeatDetailsRepository  extends JpaRepository<SeatDetailsEntity, Integer> 
{
	
}

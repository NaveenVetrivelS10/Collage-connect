package com.example.TicketBooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.TicketBooking.entity.TheatersDetailsEntity;

public interface TheatersDetailsRepository  extends JpaRepository<TheatersDetailsEntity, Integer> 
{

	List<TheatersDetailsEntity> findByPlace(String place);

	

	
}

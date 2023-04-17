package com.example.TicketBooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.TicketBooking.entity.UserBookedDetails;

public interface UserBookedDetailsRepo extends JpaRepository<UserBookedDetails, Integer>
{
	
}

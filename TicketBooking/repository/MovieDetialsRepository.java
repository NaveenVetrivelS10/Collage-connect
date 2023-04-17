package com.example.TicketBooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.TicketBooking.entity.MovieDetialsEntity;




@Repository
public interface MovieDetialsRepository extends JpaRepository<MovieDetialsEntity, Integer>
{
	
	
}


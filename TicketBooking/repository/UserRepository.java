package com.example.TicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.TicketBooking.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	@Query(value = "select * from user_info where name=:username", nativeQuery = true)
	UserEntity findByUsername(String username);
}

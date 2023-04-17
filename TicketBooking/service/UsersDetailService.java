package com.example.TicketBooking.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.TicketBooking.entity.UserEntity;
import com.example.TicketBooking.repository.UserRepository;
import org.springframework.security.core.userdetails.User;

@Service
public class UsersDetailService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByUsername(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException("invalidusername");
		}
		return new User(userEntity.getName(), userEntity.getPassword(), new ArrayList<>());
	}
}

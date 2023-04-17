package com.hubino.marksheet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hubino.marksheet.entity.User;
import com.hubino.marksheet.repository.UserRepository;

@SpringBootApplication
public class MarksheetApplication {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void saveUserDetails()
	{
		List<User> user=Stream.of(
				new User(1,"sumithra","Sumi@123","smilesumi@gmail.com","Computer Science"),
				new User(2,"raguram","Ragu@123","ragu.m@gmail.com","Biology"),
				new User(3,"senthil","Senthil@123","senthil.p@gmail.com","Commerce"),
				new User(4,"ragul","Ragul@123","ragul.m@gmail.com","Computer Science"),
				new User(5,"saisundar","Sai@123","sai.m@gmail.com","Business Maths"),
				new User(6,"arutselvan","Arut@123","arut.c@gmail.com","Biology"),
				new User(7,"praveen","Motta@123","praveen.motta@gmail.com","Pure Science")
				
				).collect(Collectors.toList());
				userRepository.saveAll(user);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(MarksheetApplication.class, args);
	}

}

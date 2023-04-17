package com.hubino.marksheet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String department;

}

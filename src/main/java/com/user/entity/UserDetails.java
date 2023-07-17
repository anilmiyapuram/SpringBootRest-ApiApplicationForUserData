package com.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserDetails {
	@Id
	@GeneratedValue
	private long userId;
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private int age;
	private String nationality;
}

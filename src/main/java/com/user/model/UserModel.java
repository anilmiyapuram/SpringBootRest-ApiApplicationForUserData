package com.user.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserModel {
	@Id
	@GeneratedValue
	private long userId;
	@NotBlank(message = "name cant't be blank")
	private String name;
	@Email(message = "invalid email address")
	private String email;
	@Pattern(regexp = "^\\d{10}$",message = "invalid mobile number")
	private String mobile;
	private String gender;
	@Min(18)
	@Max(60)
	private int age;
	@NotBlank
	private String nationality;

}

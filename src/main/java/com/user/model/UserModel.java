package com.user.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
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
	private String userName;
	@Email(message = "invalid email address")
	private String email;
	@Pattern(regexp = "^\\d{10}$",message = "invalid mobile number")
	private String mobile;
	@NotBlank
	@NotNull
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",message = "invalid password type")
	private String password;
	private String gender;
	@Min(18)
	@Max(60)
	private int age;
	@NotBlank
	private String nationality;
	@NotBlank
	private String roles;

}

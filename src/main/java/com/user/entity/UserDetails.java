package com.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Table(name = "user_management")
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	private String userName;
	private String email;
	private String mobile;
	private String password;
	private String gender;
	private int age;
	private String nationality;
	private String roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}

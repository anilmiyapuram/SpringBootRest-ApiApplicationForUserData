package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.UserDetails;
import com.user.exceptions.DuplicateRecordException;
import com.user.exceptions.UserNotFoundException;
import com.user.model.UserModel;
import com.user.service.UserInterface;

import jakarta.validation.Valid;


@RestController
public class UserController {
	@Autowired
	private UserInterface userService;

	@PostMapping("/save")
	public String saveUser(@RequestBody @Valid UserModel user) throws DuplicateRecordException{


		return userService.saveUser(user);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<UserDetails>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	} 
	@GetMapping("/get/{id}")
	public ResponseEntity<UserDetails> getUser(@PathVariable long id) throws UserNotFoundException {
		return ResponseEntity.ok(userService.getUser(id));
	}
	@PutMapping("/{id}")
	public UserDetails updateUser(@PathVariable Long id, @RequestBody @Valid UserDetails updatedUser) throws UserNotFoundException {
		return userService.updateUser(id, updatedUser);

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		boolean deleted = userService.deleteUser(id);
		if (deleted) {
			return ResponseEntity.ok("User deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}

	}
}

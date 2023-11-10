package com.user.service;

import java.util.List;

import com.user.entity.UserDetails;
import com.user.exceptions.DuplicateRecordException;
import com.user.exceptions.UserNotFoundException;
import com.user.model.UserModel;

public interface UserInterface{
	public UserDetails saveUser(UserDetails user)throws DuplicateRecordException;
	public List<UserDetails> getAllUsers();
	public UserDetails getUser(Long id) throws UserNotFoundException;
	public UserDetails updateUser(long id,UserDetails user) throws UserNotFoundException;
	public boolean deleteUser(long id);
}

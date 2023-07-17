package com.user.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.UserDetails;
import com.user.exceptions.DuplicateRecordException;
import com.user.exceptions.UserNotFoundException;
import com.user.model.UserModel;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpleClass implements UserInterface {
	@Autowired
	private UserRepository userRepo;
	@Override
	public String saveUser(UserModel user) throws DuplicateRecordException {
		if (userRepo.existsByMobile(user.getMobile())) {
            throw new DuplicateRecordException("Mobile number already exists");
        }

        if (userRepo.existsByEmail(user.getEmail())) {
            throw new DuplicateRecordException("Email already exists");
        }

        UserDetails userEntity=new UserDetails();
		BeanUtils.copyProperties(user, userEntity);
		if(userRepo.save(userEntity)!=null) {
			return "User Record inserted sucessfully";	
		}
		else {
			return "User Record not inserted";
		}
    }
	
	public List<UserDetails> getAllUsers(){
		return userRepo.findAll();
	}
	public UserDetails getUser(Long id) throws UserNotFoundException {
		UserDetails user = userRepo.findByUserId(id);
		if(user!=null) {
			return user;
		}
		else {
			throw new UserNotFoundException("user id " + id +" not found: ");
		}
	}
	@Override
	public UserDetails updateUser(long id, UserDetails user) throws UserNotFoundException {
		UserDetails existingUser = userRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found. "+id));

		user.setUserId(existingUser.getUserId());
		return userRepo.save(user);

	}
	@Override
	public boolean deleteUser(long id) {
		if(userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return true;
		}
		else
			return false;
	}

}

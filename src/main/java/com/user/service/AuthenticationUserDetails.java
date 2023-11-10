package com.user.service;

import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AuthenticationUserDetails implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.user.entity.UserDetails userDetails = userRepository.findByEmailIgnoreCase(username)
                .orElseThrow(() -> new NoSuchElementException("The requested user with username "+username+" is not found"));
        return (UserDetails) userDetails;
    }
}

package com.deep.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.model.CustomUserDetail;
import com.deep.model.User;
import com.deep.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user= userRepository.findUserByEmail(email);
		user.orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
		return user.map(CustomUserDetail::new).get();
	}

}

package com.techprimers.security.springsecurityauthserver.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techprimers.security.springsecurityauthserver.model.CustomeUserDetails;
import com.techprimers.security.springsecurityauthserver.model.Users;
import com.techprimers.security.springsecurityauthserver.repository.UserRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("user name is::"+username);

		
		Optional<Users> usersOptional = userRepo.findByuserName(username);
		
		System.out.println("user size  is::"+usersOptional);

		usersOptional.orElseThrow(() -> new UsernameNotFoundException("User is not found"));

		return usersOptional.map(CustomeUserDetails::new).get();
	}

}

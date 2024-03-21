/*package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.entity.User;
import com.security.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	    @Autowired
	    private UserRepository userRepository;
	      
	    @Override
	    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	        User user = userRepository.findByUserName(userName);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found with username: " + userName);
	        }
	        return org.springframework.security.core.userdetails.User.withUsername(user.getName())
	            .password(user.getPassword())
	            .roles(user.getRoles())
	            .accountLocked(!user.isEnabled())
	            .build();
	    }
	}
*/
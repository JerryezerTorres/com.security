package com.security.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.entity.User;
import com.security.repository.UserRepository;
import com.security.service.IUserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	    @Autowired
	    private UserRepository userRepository;
	    
	    @Autowired
	    private IUserService userService;
	      
	    @Override
	    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	    	User user = userRepository.findByUserName(userName);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found with username: " + userName);
	        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getRoles().contains("ADMIN")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        // Construcción del objeto UserDetails con roles configurados
        return new org.springframework.security.core.userdetails.User(
            user.getUserName(), user.getPassword(), authorities);
    }
	}






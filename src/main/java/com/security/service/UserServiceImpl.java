package com.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.entity.User;
import com.security.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void save(User user) {
		userRepository.save(user);	
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
		
	}

}

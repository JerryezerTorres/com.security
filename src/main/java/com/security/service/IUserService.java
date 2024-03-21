package com.security.service;

import java.util.List;
import java.util.Optional;

import com.security.entity.User;

public interface IUserService {
	
	
	public void save(User user);
	public Optional<User> findById(Long id);
	public List<User> findAll();
	public void delete(Long id);
	
	public User findByUserName(String userName);
	
	

}

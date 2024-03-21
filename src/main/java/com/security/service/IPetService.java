package com.security.service;

import java.util.List;
import java.util.Optional;

import com.security.entity.Pet;

public interface IPetService  {

	public void save(Pet pet);
	public Optional <Pet> findById(Long id);
	public List<Pet> findAll();
	public void delete(Long id);
	
	
}

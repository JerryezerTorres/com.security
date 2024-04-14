package com.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.entity.Pet;
import com.security.entity.User;
import com.security.repository.PetRepository;

@Service
public class PetServiceImpl implements IPetService {

	@Autowired
	private PetRepository petRepository;
	
	@Override
	public void save(Pet pet) {
		petRepository.save(pet);	
	}

	@Override
	public Optional<Pet> findById(Long id) {
		return petRepository.findById(id);
	}

	@Override
	public List<Pet> findAll() {
		return petRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		petRepository.deleteById(id);
		
	}

	@Override
	public List<Pet> findActivePetsByUser(User user) {
		  return petRepository.findByUserAndEnabled(user, true);
		  
	}

}

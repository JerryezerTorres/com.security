package com.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.entity.Pet;
import com.security.entity.User;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

	 List<Pet> findByUserAndEnabled(User user, boolean enabled);	

}

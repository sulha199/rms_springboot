package com.shulha.spbootrms.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	// fetch by username
	Optional<User> findByUsername(String username);
	
	List<User> findAll();
}

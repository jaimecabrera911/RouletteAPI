package com.roulette.api.service;

import java.util.List;
import java.util.Optional;

import com.roulette.api.entity.User;

public interface UserServiceInterface {

	public User save(User user);

	public Optional<User> findById(Long id);

	public List<User> findAll();

	public void deleteById(long id);
	
}

package com.roulette.api.service;

import java.util.List;
import java.util.Optional;

import com.roulette.api.entity.Roulette;

public interface RouletteServiceInterface {
	
	
	public Roulette save(Roulette roulette);


	public Optional<Roulette> findById(Long id);


	public List<Roulette> findAll();


	public void deleteById(long id);
}

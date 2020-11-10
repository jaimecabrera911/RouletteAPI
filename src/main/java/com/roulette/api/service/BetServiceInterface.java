package com.roulette.api.service;

import java.util.List;
import java.util.Optional;

import com.roulette.api.entity.Bet;

public interface BetServiceInterface {

	public List<Bet> findAll();

	public Bet save(Bet user);

	public Optional<Bet> findById(long id);

	public void deleteById(long id);
	
	
}

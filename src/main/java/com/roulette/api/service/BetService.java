package com.roulette.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roulette.api.entity.Bet;
import com.roulette.api.repository.BetRepository;

@Service
public class BetService implements  BetServiceInterface {

	@Autowired
	BetRepository betRepository;	
	
	@Override
	public List<Bet> findAll() {
		// TODO Auto-generated method stub
		return (List<Bet>) betRepository.findAll();
	}

	@Override
	public Bet save(Bet user) {
		// TODO Auto-generated method stub
		return betRepository.save(user);
	}

	@Override
	public Optional<Bet> findById(long id) {
		// TODO Auto-generated method stub
		return betRepository.findById(id);
	}

	@Override
	public void deleteById(long id) {
		
		betRepository.deleteById(id);
	}

}

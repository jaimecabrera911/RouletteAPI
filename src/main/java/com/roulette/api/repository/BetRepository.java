package com.roulette.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.roulette.api.entity.Bet;

public interface BetRepository extends CrudRepository<Bet, Long> {

}

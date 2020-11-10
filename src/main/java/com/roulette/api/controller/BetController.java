package com.roulette.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roulette.api.entity.Bet;
import com.roulette.api.service.BetService;

@RestController
@RequestMapping("/api")
public class BetController {

	@Autowired
	BetService betService;

	@GetMapping("/bets")
	public List<Bet> bets() {
		return betService.findAll();
	}

	@PostMapping("/bets")
	public Bet save(@Valid @RequestBody Bet bet) {
		return betService.save(bet);
	}
}

package com.roulette.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.roulette.api.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

}

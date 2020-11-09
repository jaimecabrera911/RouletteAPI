package com.roulette.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roulette.api.entity.User;
import com.roulette.api.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> users() {
		return userService.findAll();
	}

	@PostMapping("/users")
	public User save(@Valid @RequestBody User user) {
		userService.save(user);
		return user;
	}

	@DeleteMapping("/users/{id}")
	public Map<String, String> delete(@PathVariable long id) {
		HashMap<String, String> message = new HashMap<>();
		message.put("message", "user deleted successfully");
		userService.deleteById(id);
		return message;

	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user) {
		Optional<User> userData = userService.findById(id);

		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setNames(user.getNames());
			_user.setEmail(user.getEmail());
			_user.setSurnames(user.getSurnames());
			return new ResponseEntity<>(userService.save(_user), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}

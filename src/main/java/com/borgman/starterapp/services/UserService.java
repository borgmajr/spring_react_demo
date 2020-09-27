package com.borgman.starterapp.services;

import java.util.Optional;

import com.borgman.starterapp.model.security.User;


public interface UserService {

	Optional<User> findById(Long id);

	Optional<User> findByUserName(String username);

	public void save(User user);
}

package com.borgman.starterapp.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.borgman.starterapp.model.security.User;
import com.borgman.starterapp.services.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	@Qualifier("com.borgman.starterapp.services.sql.postgres.UserSqlService")
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userService.findByUserName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("User: " + userName + " not found"));

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority("user")));
	}
}
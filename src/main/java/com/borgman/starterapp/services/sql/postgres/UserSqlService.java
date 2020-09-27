package com.borgman.starterapp.services.sql.postgres;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.borgman.starterapp.model.security.User;
import com.borgman.starterapp.services.UserService;

@Component("com.borgman.starterapp.services.sql.postgres.UserSqlService")
public class UserSqlService implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Optional<User> findById(Long id) {

		return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM users where id = ? and deleted = false",
				new Object[] { id }, new BeanPropertyRowMapper<User>(User.class)));

	}

	@Override
	public Optional<User> findByUserName(String username) {
		return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM users where username = ? and deleted = false",
				new Object[] { username }, new BeanPropertyRowMapper<User>(User.class)));
	}

	@Override
	public void save(User user) {
		if (null != user && null != user.getId()) {
			jdbcTemplate.update("UPDATE users set username = ?, password = ?, email = ? where id = ?",
					new Object[] { user.getUsername(), user.getPassword(), user.getEmail(), user.getId() });
		} else {
			jdbcTemplate.update("INSERT INTO users(username,password,email) values (?,?,?)",
					new Object[] { user.getUsername(), user.getPassword(), user.getEmail() });
		}

	}

}

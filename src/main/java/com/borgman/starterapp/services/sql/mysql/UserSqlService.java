package com.borgman.starterapp.services.sql.mysql;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.borgman.starterapp.model.security.User;
import com.borgman.starterapp.services.UserService;

@Component("com.borgman.starterapp.services.sql.mysql.UserSqlService")
public class UserSqlService implements UserService {

	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

}

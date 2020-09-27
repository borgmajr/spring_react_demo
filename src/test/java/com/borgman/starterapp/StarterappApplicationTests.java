package com.borgman.starterapp;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.borgman.starterapp.model.security.User;
import com.borgman.starterapp.services.UserService;

@SpringBootTest()
class StarterappApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(StarterappApplication.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("com.borgman.starterapp.services.sql.postgres.UserSqlService")
	private UserService userService;

	@Test
	void contextLoads() {

		log.info("########################################################################");

		try {
			{
				Resource resource = new ClassPathResource("sql/001_init.sql");
				ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
				databasePopulator.execute(getAdminDataSource());
			}

			{
				Resource resource = new ClassPathResource("sql/002_init_tables.sql");
				ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
				databasePopulator.execute(jdbcTemplate.getDataSource());
			}
		} catch (Exception e) {
			log.info(">>>>>>>>>>>>> INIT SCRIPTS SKIPPED <<<<<<<<<<<<<<<<<<<<");
		}

		// insert admin:admin
		try {
			// https://www.browserling.com/tools/bcrypt
			userService.save(
					new User("admin", "$2a$10$mF6S4O/5uOU5CaeQpHGdWOaglASC8Ri4cGB0nyQg3bJbeoVlV5dZa",
					"admin@test.com"));
			System.out.println("******* USER CREATED *********");
		} catch (Exception e) {
			System.out.println("******* USER SKIPPED *********");
		}

		log.info("StartApplication...");
		log.info("########################################################################");

	}

	public DataSource getAdminDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.postgresql.Driver");
		dataSourceBuilder.url("jdbc:postgresql://127.0.0.1:5432/");
		dataSourceBuilder.username("postgres");
		dataSourceBuilder.password("");
		return dataSourceBuilder.build();
	}

}

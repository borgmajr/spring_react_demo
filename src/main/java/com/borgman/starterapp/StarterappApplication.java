package com.borgman.starterapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class StarterappApplication {

	private static final Logger log = LoggerFactory.getLogger(StarterappApplication.class);


	
	public static void main(String[] args) {
		SpringApplication.run(StarterappApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
	}

	
}

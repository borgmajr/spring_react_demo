package com.borgman.starterapp.web.system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SystemTimeController {

	@GetMapping("/api/system/time")
	public String time() {
		return "Hello, the time at the server is now " + new Date();
	}

}
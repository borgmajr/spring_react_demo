package com.borgman.starterapp.services.sql.postgres;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.borgman.starterapp.model.Currency;
import com.borgman.starterapp.services.CurrencyServices;

@SpringBootTest()
class CurrencySqlServicesTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Autowired
	private CurrencyServices currencyServices;

	@Test
	void test() {

		currencyServices.save(new Currency("US Dolar", "USD", new BigDecimal(100), new BigDecimal(3.92)));
		currencyServices.save(new Currency("Euro", "EUR", new BigDecimal(300), new BigDecimal(4.52)));

		assertEquals(2, currencyServices.findAll().size());
	}

}

package com.borgman.starterapp.services.sql.postgres;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.borgman.starterapp.model.Currency;
import com.borgman.starterapp.services.CurrencyServices;

@Component("com.borgman.starterapp.services.sql.postgres.CurrencySqlServices")
public class CurrencySqlServices implements CurrencyServices {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long count() {
		return jdbcTemplate.queryForObject("SELECT count(*) FROM currency", new Object[] {}, Integer.class);
	}

	@Override
	public void save(Currency currency) {
		if (null != currency && null != currency.getId()) {
			jdbcTemplate.update("UPDATE currency set name = ?, code = ?, amount = ?, rate = ? where id = ?",
					new Object[] { currency.getName(), currency.getCode(), currency.getAmount(), currency.getRate(),
							currency.getId() });
		} else {
			jdbcTemplate.update("INSERT INTO currency(name,code,amount,rate) values (?,?,?,?)",
					new Object[] { currency.getName(), currency.getCode(), currency.getAmount(), currency.getRate() });
		}
	}

	@Override
	public List<Currency> findAll() {
		return jdbcTemplate.query("SELECT * FROM currency", new Object[] {},
				new BeanPropertyRowMapper<Currency>(Currency.class));
	}

	@Override
	public Optional<Currency> findById(long id) {
		return Optional.of(jdbcTemplate.queryForObject("SELECT * FROM currency where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Currency>(Currency.class)));
	}

	@Override
	public void deleteById(Long id) {
		jdbcTemplate.update("delete from currency where id = ?", new Object[] { id });
	}

}

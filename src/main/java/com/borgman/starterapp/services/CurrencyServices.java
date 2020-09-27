package com.borgman.starterapp.services;

import java.util.List;
import java.util.Optional;

import com.borgman.starterapp.model.Currency;

public interface CurrencyServices {

	public long count();

	public void save(Currency currency);

	public List<Currency> findAll();

	public Optional<Currency> findById(long id);

	public void deleteById(Long id);
}

package com.borgman.starterapp.model;

import java.math.BigDecimal;

public class Currency {

	private Long id;
	private String name;
	private String code;
	private BigDecimal amount;
	private BigDecimal rate;

	public Currency() {

	}

	public Currency(String name, String code, BigDecimal amount, BigDecimal rate) {
		this.name = name;
		this.code = code;
		this.amount = amount;
		this.rate = rate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

}

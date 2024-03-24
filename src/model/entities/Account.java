package model.entities;

import model.exceptions.ValueFailure;

public class Account {

	private Integer number;
	private String houlder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {

	}

	public Account(Integer number, String houlder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.houlder = houlder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHoulder() {
		return houlder;
	}

	public void setHoulder(String houlder) {
		this.houlder = houlder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(Double amount) {
		balance += amount;
	}

	public void withdraw(Double amount) {
		validationWithdraw(amount);
		balance -= amount;
	}
	
	public void validationWithdraw(Double amount) {
		if (getBalance() < amount)
			throw new ValueFailure("Not enough balance");
		else if (getWithdrawLimit() < amount) {
			throw new ValueFailure("the amount exceed withdraw limit");
		}
		
	}
}

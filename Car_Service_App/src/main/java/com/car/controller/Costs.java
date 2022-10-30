package com.car.controller;

public enum Costs {

	serviceCharge(1000), wheelAlignment(200), gearCheckUp(100), oilsCheckUp(200);
	
	private int amount;

	private Costs(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}

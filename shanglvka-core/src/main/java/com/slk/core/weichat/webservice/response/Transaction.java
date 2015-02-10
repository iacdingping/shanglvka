package com.slk.core.weichat.webservice.response;

import com.slk.core.weichat.webservice.PropertyKey;

public class Transaction {
	@PropertyKey("MerchantName")
	private String merchantName;
	@PropertyKey("TransactionTime")
	private String transactionTime;
	@PropertyKey("Money")
	private Float money;
	@PropertyKey("CardBalanceBefore")
	private Float cardBalanceBefore;
	@PropertyKey("CardBalance")
	private Float cardBalance;
	public Transaction() {
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	public Float getMoney() {
		return money;
	}
	public void setMoney(Float money) {
		this.money = money;
	}
	public Float getCardBalanceBefore() {
		return cardBalanceBefore;
	}
	public void setCardBalanceBefore(Float cardBalanceBefore) {
		this.cardBalanceBefore = cardBalanceBefore;
	}
	public Float getCardBalance() {
		return cardBalance;
	}
	public void setCardBalance(Float cardBalance) {
		this.cardBalance = cardBalance;
	}
}

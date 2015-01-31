package com.slk.core.weichat.webservice.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetTransactionResponse extends BaseResponse {

	@JsonProperty("Transactions")
	private List<Transaction> transactions;
	
	public GetTransactionResponse() {
		super();
	}
	public GetTransactionResponse(Integer result, String errorCode, String errorMsg) {
		super(result, errorCode, errorMsg);
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public class Transaction {
		@JsonProperty("MerchantName")
		private String merchantName;
		@JsonProperty("TransactionTime")
		private String transactionTime;
		@JsonProperty("Money")
		private Float money;
		@JsonProperty("CardBalanceBefore")
		private Float cardBalanceBefore;
		@JsonProperty("CardBalance")
		private Float cardBalance;
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
}

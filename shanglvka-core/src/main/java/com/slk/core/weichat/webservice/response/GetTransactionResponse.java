package com.slk.core.weichat.webservice.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
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

}

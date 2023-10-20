package com.BankAccount.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "/TB_TRANSACTION")

public class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "Origin_Id")
	private User userOriginId;
	@ManyToOne
	@JoinColumn(name = "Final_Id")
	private User userFinalId;
	private double amount;
	public Transaction(Long id, User userOriginId, User userFinalId, double amount) {
		super();
		this.id = id;
		this.userOriginId = userOriginId;
		this.userFinalId = userFinalId;
		this.amount = amount;
	}

	public Transaction() {
	}

	public User getUserOriginId() {
		return userOriginId;
	}

	public void setUserOriginId(User userOriginId) {
		this.userOriginId = userOriginId;
	}

	public User getUserFinalId() {
		return userFinalId;
	}

	public void setUserFinalId(User userFinalId) {
		this.userFinalId = userFinalId;
	}

	public double getTransactionAmount() {
		return amount;
	}

	public void setTransactionAmount(double amount) {
		this.amount = amount;
	}
	
	

}

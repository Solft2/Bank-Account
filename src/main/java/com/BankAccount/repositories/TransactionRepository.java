package com.BankAccount.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankAccount.entities.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction,Long>{

}

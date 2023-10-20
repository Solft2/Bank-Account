package com.BankAccount.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankAccount.entities.Transaction;
import com.BankAccount.entities.User;
import com.BankAccount.repositories.TransactionRepository;

@Service

public class TransactionService {
  @Autowired
  TransactionRepository transactionRepository;
  
  @Autowired
  UserService userService;
  
  public boolean transaction(Long userOriginId, Long userFinalId, double amount) {
	  System.out.println("Metodo de transacao chamado");
	  System.out.println("UsuarioOriginId: " + userOriginId);
	   System.out.println("UsuarioFinalId: " + userFinalId);
	    System.out.println("Valor: " + amount);
	  if(userOriginId == null || userFinalId == null || userOriginId.equals(userFinalId)) {
		  return false;
	  }
	  User userOrigin = userService.findById(userOriginId);
	  User  userFinal = userService.findById(userFinalId);
	  
	  if(userOrigin.getBalance() < amount) {
		  return false;
	  }
	  
	  
	  
	  Transaction transaction = new Transaction();
	  transaction.setTransactionAmount(amount);
	  System.out.println("Valor antes de salvar: " + transaction.getTransactionAmount());
	  transaction.setUserFinalId(userFinal);
	  transaction.setUserOriginId(userOrigin);
	 
	  
	  userOrigin.setBalance(userOrigin.getBalance() - amount);
	  userFinal.setBalance(userFinal.getBalance() + amount);
	  
	  userService.updateBalance(userOrigin);
	  userService.updateBalance(userFinal);
	  transactionRepository.save(transaction);
	  
	  return true;
  }
}

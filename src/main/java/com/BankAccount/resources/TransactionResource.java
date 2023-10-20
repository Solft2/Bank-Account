package com.BankAccount.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.BankAccount.DTOS.TransactionDTO;
import com.BankAccount.entities.User;
import com.BankAccount.services.TransactionService;
import com.BankAccount.services.UserService;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionResource {
   @Autowired
   private TransactionService transactionService;
   @Autowired
   private UserService userService;
   
   
   @PostMapping
   public ResponseEntity<String> criarTransicao(@RequestBody TransactionDTO transaction){
	   System.out.println("Metodo de criação chamado");
	   System.out.println("Id origem:" + transaction.userOriginId());
	   System.out.println("Id destino: " + transaction.userFinalId());
	   System.out.println("Valor: " + transaction.amount());
	   Long userOriginId = transaction.userOriginId();
	   Long userFinalId = transaction.userFinalId();
	   double valorTranscacao = transaction.amount();
	   
	   System.out.println("valor pós transação: " + transaction.amount());
	   
	   User userOrigem = userService.findById(userOriginId);
	   User userDestino = userService.findById(userFinalId);
	   
	   if(userOrigem != null && userDestino != null) {	   
	   boolean sucesso = transactionService.transaction(userOriginId, userFinalId, valorTranscacao);	   
	   if(sucesso) {
		   return ResponseEntity.ok("Transação realizada com sucesso");
	   }else {
		   return ResponseEntity.badRequest().body("Transação não foi possivel");
	   }
   }else{
		 return ResponseEntity.badRequest().body("Usuario não encontrado");
   }
   }
}

package com.BankAccount.DTOS;

public record TransactionDTO(Long userOriginId, Long userFinalId, double amount) {}

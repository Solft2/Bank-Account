package com.BankAccount.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankAccount.entities.User;


public interface UserRepository extends JpaRepository<User,Long>{
	Optional<User> findByEmail(String email);
	Optional<User> findByCpf(String cpf);

}

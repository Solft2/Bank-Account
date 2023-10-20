package com.BankAccount.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import com.BankAccount.entities.enums.AccountType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CONTAS")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
    private String cpf; 
    private String name;
    private String email;
    private String password;
    private double balance;
    private AccountType accountType;
    @OneToMany(mappedBy = "userOriginId")
    private Set<Transaction> transacoesEnviadas;
    
    @OneToMany(mappedBy = "userFinalId")
    private Set<Transaction> transacoesRecebidas;
	public User() {}
	
	public User(Long id, String cpf, String name, String email, String password, double balance,AccountType accountType) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.password = password;
		this.balance = balance;
		this.accountType = accountType;
		
	}
    
	public void setaccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public AccountType getaccountType() {
		return accountType;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
    
    
}

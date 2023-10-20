package com.BankAccount.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankAccount.entities.User;
import com.BankAccount.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
   private UserRepository userRepository;

	public UserService() {	
	}
    public List<User> findAll(){
    	return userRepository.findAll();
    }
    public User findByEmail(String email) {
    	Optional<User> obj = userRepository.findByEmail(email);
    	return obj.get();
    }
    public User findById(Long id) {
    	Optional<User> obj = userRepository.findById(id);
    	if(obj.isPresent()) {
    	return obj.get();
    	}else {
    		throw new RuntimeException("Id invalido: " + id);
    	}
    }
    public User updateBalance(User user) {
    	return userRepository.save(user);    	
    }
    public User insert(User obj) {
    	if(!emailAndCpfAlreadyInUse(obj.getEmail(),obj. getCpf())){
    	return userRepository.save(obj);
    	}else {
    	 throw new RuntimeException("Email ou cpf já está sendo usado");
    	}
    }
    
    public void delete(Long id) {
    	userRepository.deleteById(id);
    } 
    public User update(User obj, Long id) {
    	User entity = userRepository.getReferenceById(id);
    	updateData(entity, obj);
    	return userRepository.save(entity);
    }
    
    private void updateData(User entity, User obj) {
    	entity.setEmail(obj.getEmail());
    	entity.setName(obj.getName());
    	entity.setPassword(obj.getPassword());    	
    }
    
    private boolean emailAndCpfAlreadyInUse(String email, String cpf) {
    	return userRepository.findByEmail(email).isPresent() || userRepository.findByCpf(cpf).isPresent();
    }
    
}
     


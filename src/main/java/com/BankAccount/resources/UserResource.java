package com.BankAccount.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.BankAccount.entities.User;
import com.BankAccount.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
    UserService userService;

	public UserResource(){}
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
    	User obj = userService.findById(id);
    	return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/{id}/saldo")
    public ResponseEntity<Double> saldo(@PathVariable Long id){
    	User obj = userService.findById(id);
    	double saldo = obj.getBalance();
    	return ResponseEntity.ok().body(saldo);   	
    }
    @PostMapping
    public ResponseEntity<User> insertUsuario(@RequestBody User obj){
    	User entity = userService.insert(obj);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    	return ResponseEntity.created(uri).body(entity);
    }
   
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
    	userService.delete(id);
    	return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUsuarios(@PathVariable Long id, @RequestBody User obj){
    	User entity = userService.update(obj, id);
    	return ResponseEntity.ok().body(entity);
    }
}

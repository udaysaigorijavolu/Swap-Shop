package com.swapshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapshop.entity.UserSignUp;
import com.swapshop.repository.SignUpRepo;

@Service
public class SignUpService {

	@Autowired
	private SignUpRepo repository;
	 
	public UserSignUp saveUser(UserSignUp signup) {
		return repository.save(signup);
	}
	public UserSignUp updateUser(UserSignUp signup, int id) {
		signup.setId(id);
		return repository.save(signup);
	}
	public boolean deleteUser(int id) {
		repository.deleteById(id);
		return true;
	}
	public List<UserSignUp> getAllUsers(UserSignUp signup){
		return repository.findAll();
	}
	public UserSignUp getUser( int id,UserSignUp signup ) {
		return repository.findById(id).get();
	}
}

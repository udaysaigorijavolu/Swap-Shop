package com.swapshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swapshop.entity.UserSignIn;
import com.swapshop.repository.SignInRepo;

@Service
public class SignInService {
	@Autowired
	private SignInRepo repository;
	
	public UserSignIn saveUserSignIn(UserSignIn signin) {
		return repository.save(signin);
	}
	public List<UserSignIn> getAllSignInDetails(UserSignIn signin){
		return repository.findAll();
	}
}

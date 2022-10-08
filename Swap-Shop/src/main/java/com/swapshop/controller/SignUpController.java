package com.swapshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swapshop.entity.UserSignUp;
import com.swapshop.service.SignUpService;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {
	@Autowired
	private SignUpService signupService;
	@PostMapping("/add")
	public UserSignUp saveUser(@RequestBody UserSignUp signup) {
		return signupService.saveUser(signup);
	}
	@PutMapping("/update/{id}")
	public UserSignUp updateUser(@RequestBody UserSignUp signup ,@PathVariable int id) {
		return signupService.updateUser(signup, id);
	}
	@DeleteMapping("/delete/{id}")
	public boolean deleteUser(@PathVariable int id) {
		signupService.deleteUser(id);
		return true;
	}
	@GetMapping("/get")
	public List<UserSignUp> getAllUsers(@RequestBody UserSignUp signup) {
		 return signupService.getAllUsers(signup);
	}
	@GetMapping("/get/{id}")
	public UserSignUp getUserbyId(@RequestBody UserSignUp signup,@PathVariable int id) {
		return signupService.getUser(id, signup);
	}
}

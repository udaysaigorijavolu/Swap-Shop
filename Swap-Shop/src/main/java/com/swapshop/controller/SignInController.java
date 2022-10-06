package com.swapshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swapshop.entity.UserSignIn;
import com.swapshop.service.SignInService;

@RestController
@RequestMapping("/api/signin")
public class SignInController {
	@Autowired
	private SignInService signinService;
	@PostMapping("/add")
	public UserSignIn saveSignInUser(@RequestBody UserSignIn signIn) {
		return signinService.saveUserSignIn(signIn);
	}
}

package com.swapshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swapshop.entity.UserSignUp;

@Repository

public interface SignUpRepo extends JpaRepository<UserSignUp, Integer>{
	
}

package com.swapshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swapshop.entity.UserSignIn;

@Repository
public interface SignInRepo extends JpaRepository<UserSignIn, Integer> {

}

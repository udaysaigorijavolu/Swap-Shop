package com.swapshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.swapshop.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	

}

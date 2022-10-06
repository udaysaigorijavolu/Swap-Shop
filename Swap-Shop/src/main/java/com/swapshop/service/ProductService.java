package com.swapshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapshop.dao.ProductDao;
import com.swapshop.entity.Product;

@Service
public class ProductService  {
	
	@Autowired
	private ProductDao productdao;
	
	public Product saveProduct(Product product) {
		return productdao.save(product);
	}
	
	public List<Product> getAllProducts(){
		return productdao.findAll();
	}
	
	
	public String deleteProductById(int id) {
		 productdao.deleteById(id);
		 return "Deleted successfully";
	}
	
	
	public Product updateProductById(Product product, int id) {
		product.setId(id);
		return productdao.save(product);
	}  
		
	
	
	public Product getProductById(int id) {
		return productdao.findById(id).get();
		
	}
	
	}



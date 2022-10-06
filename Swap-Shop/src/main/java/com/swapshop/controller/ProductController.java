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

import com.swapshop.entity.Product;
import com.swapshop.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
@Autowired
private ProductService proservice;

@PostMapping("/save")
public Product saveProduct(@RequestBody Product product) {
	return proservice.saveProduct(product);
	
}

@GetMapping("/list")
public List<Product> getAllProducts(){
	 return proservice.getAllProducts();
}

@PutMapping("/update/{id}")
public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
	return proservice.updateProductById(product, id);
	
}

@DeleteMapping("/delete/{id}")
public String deleteProductById(@PathVariable int id) {
	 proservice.deleteProductById(id);
	 return "Deleted Successfully.";
}

@GetMapping("/id")
public Product getProductById(@PathVariable int id) {
	return proservice.getProductById(id);
}
}

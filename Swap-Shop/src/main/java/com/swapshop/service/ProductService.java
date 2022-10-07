package com.swapshop.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.swapshop.dao.ProductDao;
import com.swapshop.entity.Product;
import com.swapshop.helper.CSVHelper;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;

	public void save(MultipartFile file) {
		try {
			List<Product> products = CSVHelper.csvToProducts(file.getInputStream());
			dao.saveAll(products);
			
		}catch(Exception e) {
			throw new RuntimeException("Fail to load CSVData : " +e.getMessage());
		}
	}
	
	 public ByteArrayInputStream load() {
		 
		 List<Product> tutorials = dao.findAll();
		 ByteArrayInputStream in = CSVHelper.productsToCSV(tutorials);
		 return in;
	}
	 

	 public List<Product> getAllProducts() {
		 return dao.findAll();
	 }

	 public Product updateProduct(Product product, int id) {
		 try {
			 product.setId(id);
				return dao.saveAndFlush(product);
				
		 }catch(Exception e) {
			 throw new RuntimeException("Fail to Update.");
		 }
		 
	 }
	 
	 public void deleteProductById(int id) {
		 dao.deleteById(id);
	 }
}

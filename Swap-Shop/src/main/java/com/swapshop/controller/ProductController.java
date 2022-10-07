package com.swapshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.swapshop.entity.Product;
import com.swapshop.exception.ResponseMessage;
import com.swapshop.helper.CSVHelper;
import com.swapshop.service.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    if (CSVHelper.hasCSVFormat(file)) {
	      try {
	        service.save(file);
	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }
	    message = "Please upload a csv file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	  }

	  @GetMapping("getlist")
	  public ResponseEntity<List<Product>> getAllProducts() {
	    try {
	      List<Product> products = service.getAllProducts();
	      if (products.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(products, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PutMapping("update/{id}")
	  public ResponseEntity<ResponseMessage> updateProduct(@RequestBody Product product, @PathVariable int id) {
		  String message = "";
		  try {
			  product.setId(id);
			  service.updateProduct(product, id);
			  message = "Updated successfully";
			  return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			  
		  }catch(Exception e) {
			  message = "Fail to update";
		        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		  }	 
		  
	  }
	  
	  @DeleteMapping("delete/{id}")
	  public ResponseEntity<ResponseMessage> deleteProduct(@PathVariable int id) {
		  String message = "";
		  try {
			  service.deleteProductById(id);
			  message = "Deleted successfully";
			  return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			  
		  }catch(Exception e) {
			  message = "Fail to delete";
		        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		  }
		  
	  }
}

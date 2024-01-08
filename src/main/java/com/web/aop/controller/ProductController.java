package com.web.aop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.aop.annotation.TrackExecutionTime;
import com.web.aop.model.Product;
import com.web.aop.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@TrackExecutionTime
	@PostMapping("/save")
	public List<Product> saveProducts(@RequestBody List<Product> products) {
		return	service.addProduct(products);
	}

	@TrackExecutionTime
	@GetMapping("/findProducts")
	public List<Product> getProducts() {
		return service.findAllProducts();
	}
	
}
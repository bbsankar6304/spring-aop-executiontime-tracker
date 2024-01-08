package com.web.aop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.aop.model.Product;
import com.web.aop.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
    private final Random random = new Random();


	@PostConstruct
	public void initDB() {
		List<Product> list=new ArrayList<>();
		for(int i=1;i<=10000;i++) {
			list.add(new Product(i, "product"+i, random.nextInt(2000)));
		}
		repository.saveAll(list);
	}
	
	public List<Product> addProduct(List<Product> products) {
		return repository.saveAll(products);
	}

	
	public List<Product> findAllProducts() {
		return repository.findAll();
	}

}

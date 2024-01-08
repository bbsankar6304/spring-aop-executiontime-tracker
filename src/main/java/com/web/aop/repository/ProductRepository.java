package com.web.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.aop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}

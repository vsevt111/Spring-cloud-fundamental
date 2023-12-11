package com.manin.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manin.cloud.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

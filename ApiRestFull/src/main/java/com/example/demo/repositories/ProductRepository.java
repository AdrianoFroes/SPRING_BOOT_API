package com.example.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID>{

	ProductModel save(ProductModel productModel);

}

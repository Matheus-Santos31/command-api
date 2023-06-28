package com.example.commandbackend.Products;

import com.example.commandbackend.Products.Entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long>{
}

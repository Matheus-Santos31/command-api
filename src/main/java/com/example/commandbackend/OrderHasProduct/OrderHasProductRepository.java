package com.example.commandbackend.OrderHasProduct;

import com.example.commandbackend.OrderHasProduct.Entities.OrderHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHasProductRepository extends JpaRepository<OrderHasProduct, Long> {
}

package com.example.commandbackend.Orders;

import com.example.commandbackend.Orders.Entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}

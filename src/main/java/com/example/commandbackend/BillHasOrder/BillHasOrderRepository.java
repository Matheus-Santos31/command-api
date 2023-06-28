package com.example.commandbackend.BillHasOrder;

import com.example.commandbackend.BillHasOrder.Entities.BillHasOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillHasOrderRepository extends JpaRepository<BillHasOrder, Long> {
}

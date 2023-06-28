package com.example.commandbackend.BillHasPayment;

import com.example.commandbackend.BillHasPayment.Entities.BillHasPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillHasPaymentRepository extends JpaRepository<BillHasPayment, Long> {
}

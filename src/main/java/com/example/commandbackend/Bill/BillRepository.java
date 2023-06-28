package com.example.commandbackend.Bill;

import com.example.commandbackend.Bill.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}

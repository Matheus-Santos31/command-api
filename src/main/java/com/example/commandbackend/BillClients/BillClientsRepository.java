package com.example.commandbackend.BillClients;

import com.example.commandbackend.BillClients.Entities.BillClients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillClientsRepository extends JpaRepository<BillClients, Long> {
}

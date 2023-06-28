package com.example.commandbackend.Clients;

import com.example.commandbackend.Clients.Entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
}

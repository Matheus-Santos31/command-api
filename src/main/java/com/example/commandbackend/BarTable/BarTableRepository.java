package com.example.commandbackend.BarTable;

import com.example.commandbackend.BarTable.Entities.BarTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarTableRepository extends JpaRepository<BarTable, Long> {
}

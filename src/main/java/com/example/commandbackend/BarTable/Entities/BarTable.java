package com.example.commandbackend.BarTable.Entities;

import com.example.commandbackend.Bill.entities.Bill;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "barTables")
@Entity(name = "barTables")
public class BarTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int numId;
    @OneToMany(mappedBy = "barTable", cascade = CascadeType.ALL)
    private List<Bill> bills;
}

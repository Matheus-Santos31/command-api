package com.example.commandbackend.BillClients.Entities;

import com.example.commandbackend.Bill.entities.Bill;
import com.example.commandbackend.Clients.Entities.Clients;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Table(name = "billClients")
@Entity(name = "billClients")
public class BillClients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @ColumnDefault(value = "false")
    private boolean generatedTicket;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Clients client;
    @ManyToOne
    @JoinColumn(name = "billId")
    private Bill bill;
}

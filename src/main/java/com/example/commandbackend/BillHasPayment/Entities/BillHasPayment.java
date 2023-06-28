package com.example.commandbackend.BillHasPayment.Entities;

import com.example.commandbackend.Bill.entities.Bill;
import jakarta.persistence.*;

@Table(name = "billHasPayment")
@Entity(name = "billHasPayment")
public class BillHasPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private float payedValue;
    @ManyToOne
    @JoinColumn(name = "billId")
    private Bill bill;
}

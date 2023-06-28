package com.example.commandbackend.BillHasOrder.Entities;

import com.example.commandbackend.Bill.entities.Bill;
import com.example.commandbackend.Orders.Entities.Orders;
import jakarta.persistence.*;

@Table(name = "billHasOrder")
@Entity(name = "billHasOrder")
public class BillHasOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "billId")
    private Bill bill;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders order;
}

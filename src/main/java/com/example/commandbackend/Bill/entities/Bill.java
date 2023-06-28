package com.example.commandbackend.Bill.entities;

import com.example.commandbackend.BarTable.Entities.BarTable;
import com.example.commandbackend.BillClients.Entities.BillClients;
import com.example.commandbackend.BillHasOrder.Entities.BillHasOrder;
import com.example.commandbackend.BillHasPayment.Entities.BillHasPayment;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "bills")
@Entity(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private boolean isPayed;
    @ManyToOne
    @JoinColumn(name = "barTableId")
    private BarTable barTable;
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<BillHasOrder> billHasOrderList;
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<BillHasPayment> billHasPaymentList;
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<BillClients> billClientsList;
}

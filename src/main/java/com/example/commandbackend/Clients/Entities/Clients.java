package com.example.commandbackend.Clients.Entities;

import com.example.commandbackend.BillClients.Entities.BillClients;
import com.example.commandbackend.Orders.Entities.Orders;
import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;


@Table(name = "clients")
@Entity(name = "clients")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String document;
    @Column
    @ColumnDefault(value = "false")
    private boolean hasTicket;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Orders> orders;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<BillClients> billClientsList;

    public Clients() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public boolean isHasTicket() {
        return hasTicket;
    }

    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<BillClients> getBillClientsList() {
        return billClientsList;
    }

    public void setBillClientsList(List<BillClients> billClientsList) {
        this.billClientsList = billClientsList;
    }
}

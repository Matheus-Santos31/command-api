package com.example.commandbackend.Clients.Dtos;

public class ClientDto {
    public Long id;
    public String name;
    public String document;
    public boolean hasTicket;

    public ClientDto(Long id, String name, String document, boolean hasTicket) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.hasTicket = hasTicket;
    }
}

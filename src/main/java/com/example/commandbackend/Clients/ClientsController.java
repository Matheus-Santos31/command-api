package com.example.commandbackend.Clients;

import com.example.commandbackend.Clients.Dtos.ClientDto;
import com.example.commandbackend.Clients.Dtos.CreateClientDto;
import com.example.commandbackend.Clients.Entities.Clients;
import com.example.commandbackend.Commom.BaseRequestResult.BaseRequestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("clients")
public class ClientsController {
    @Autowired
    private ClientsService clientsService;
    @PostMapping
    public BaseRequestResult<ClientDto> create(@RequestBody CreateClientDto clientInfo){
        try{
            ClientDto result = clientsService.create(clientInfo);
            return new BaseRequestResult(
                    HttpStatus.CREATED,
                    HttpStatus.CREATED.value(),
                    "Created Successfully",
                    result
            );
        }catch (Exception e){
            return new BaseRequestResult(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage()
            );
        }
    }

    @GetMapping({"/{id}"})
    public BaseRequestResult<ClientDto> get(@PathVariable Long id){
        try{
            ClientDto result = clientsService.getById(id);
            return new BaseRequestResult<ClientDto>(
                    HttpStatus.OK,
                    HttpStatus.OK.value(),
                    "Found Successfully",
                    result
            );
        }catch (Exception e){
            return new BaseRequestResult(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage()
            );
        }
    }

    @GetMapping({"getByDocument/{document}"})
    public BaseRequestResult<ClientDto> getByDocument(@PathVariable String document){
        try{
            ClientDto result = clientsService.getByDocument(document);
            return new BaseRequestResult<ClientDto>(
                    HttpStatus.OK,
                    HttpStatus.OK.value(),
                    "Found Successfully",
                    result
            );
        }catch (Exception e){
            return new BaseRequestResult(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage()
            );
        }
    }
}

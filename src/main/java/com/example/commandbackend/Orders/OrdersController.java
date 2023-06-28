package com.example.commandbackend.Orders;

import com.example.commandbackend.Commom.BaseRequestResult.BaseRequestResult;
import com.example.commandbackend.Orders.Dtos.CreateOrderDto;
import com.example.commandbackend.Orders.Dtos.OrderDto;
import com.example.commandbackend.Orders.Entities.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    public BaseRequestResult create(@RequestBody CreateOrderDto newOrderInfo){
        try{
            Orders newOrder = orderService.create(newOrderInfo);
            return new BaseRequestResult(
                    HttpStatus.CREATED,
                    HttpStatus.CREATED.value(),
                    "Created Successfully"
            );
        }catch (Exception e){
            return new BaseRequestResult(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage()
            );
        }
    }

    @GetMapping("/{id}")
    public BaseRequestResult<OrderDto> get(@PathVariable Long id){
        try{
            OrderDto order = orderService.getById(id);
            return new BaseRequestResult<OrderDto>(
                    HttpStatus.OK,
                    HttpStatus.OK.value(),
                    "Found successfully",
                    order);
        }catch (Exception e){
            return new BaseRequestResult(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    e.getMessage()
            );
        }
    }
}

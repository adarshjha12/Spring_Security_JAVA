package com.springDataJpa.learning.controllers;


import com.springDataJpa.learning.DTO.CreateOrderDto;
import com.springDataJpa.learning.DTO.OrderDto;
import com.springDataJpa.learning.apiResponse.ApiResponse;
import com.springDataJpa.learning.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user/{user_id}/orders")
public class OrdersController {
    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<OrderDto>> createOrder (@PathVariable Long user_id, @RequestBody CreateOrderDto createOrderDto){
        OrderDto order = orderService.createOrder(user_id, createOrderDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.of(
                201, "Order Created Successfully",  order
        ));
    }
}
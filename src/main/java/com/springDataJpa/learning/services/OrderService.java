package com.springDataJpa.learning.services;

import com.springDataJpa.learning.DTO.CreateOrderDto;
import com.springDataJpa.learning.DTO.OrderDto;
import com.springDataJpa.learning.entities.Orders;
import com.springDataJpa.learning.entities.User;
import com.springDataJpa.learning.exceptions.ResourceNotFoundException;
import com.springDataJpa.learning.repositories.OrderRepository;
import com.springDataJpa.learning.repositories.UserRepository;
import org.hibernate.query.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
private final OrderRepository orderRepository;
private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public OrderDto createOrder (Long user_id, CreateOrderDto createOrderDto){
        User user = userRepository.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("User not Found with ID: " + user_id));

        Orders order = new Orders();

        order.setProductName(createOrderDto.getProductName());
        order.setQuantity(createOrderDto.getQuantity());
        order.setUnitPrice(createOrderDto.getUnitPrice());
        order.setUser(user);

        Orders savedOrder = orderRepository.save(order);

        OrderDto orderDto = new OrderDto();
        orderDto.setId(savedOrder.getId());
        orderDto.setProductName(savedOrder.getProductName());
        orderDto.setQuantity(savedOrder.getQuantity());
        orderDto.setStatus(savedOrder.getStatus());
        orderDto.setUnitPrice(savedOrder.getUnitPrice());
        orderDto.setUserId(savedOrder.getUser().getId());

        return orderDto;
    }
}

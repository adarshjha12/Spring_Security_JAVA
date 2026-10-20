package com.springDataJpa.learning.DTO;

import com.springDataJpa.learning.entities.User;
import com.springDataJpa.learning.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderDto {
    private Long id;
    private String productName;;
    private Integer quantity;
    private BigDecimal unitPrice;
    private OrderStatus status;
    private Long userId;

}

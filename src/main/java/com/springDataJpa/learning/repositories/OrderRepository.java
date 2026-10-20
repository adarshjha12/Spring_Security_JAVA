package com.springDataJpa.learning.repositories;

import com.springDataJpa.learning.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}

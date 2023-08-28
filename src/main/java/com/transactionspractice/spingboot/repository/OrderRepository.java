package com.transactionspractice.spingboot.repository;

import com.transactionspractice.spingboot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

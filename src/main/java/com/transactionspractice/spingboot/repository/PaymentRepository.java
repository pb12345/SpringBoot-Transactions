package com.transactionspractice.spingboot.repository;

import com.transactionspractice.spingboot.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

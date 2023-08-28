package com.transactionspractice.spingboot.dto;

import com.transactionspractice.spingboot.entity.Order;
import com.transactionspractice.spingboot.entity.Payment;
import lombok.Data;

@Data
public class OrderRequest {

    private Order order;
    private Payment payment;
}

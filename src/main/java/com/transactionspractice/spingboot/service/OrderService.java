package com.transactionspractice.spingboot.service;

import com.transactionspractice.spingboot.dto.OrderRequest;
import com.transactionspractice.spingboot.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}

package com.transactionspractice.spingboot.service.impl;

import com.transactionspractice.spingboot.dto.OrderRequest;
import com.transactionspractice.spingboot.dto.OrderResponse;
import com.transactionspractice.spingboot.entity.Order;
import com.transactionspractice.spingboot.entity.Payment;
import com.transactionspractice.spingboot.exception.PaymentException;
import com.transactionspractice.spingboot.repository.OrderRepository;
import com.transactionspractice.spingboot.repository.PaymentRepository;
import com.transactionspractice.spingboot.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type not supported!");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESSFUL!");
        return orderResponse;
    }
}

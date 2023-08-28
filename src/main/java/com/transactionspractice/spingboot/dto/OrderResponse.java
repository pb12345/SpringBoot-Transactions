package com.transactionspractice.spingboot.dto;

import lombok.Data;

@Data
public class OrderResponse {
    private String orderTrackingNumber;
    private String status;
    private String message;

}

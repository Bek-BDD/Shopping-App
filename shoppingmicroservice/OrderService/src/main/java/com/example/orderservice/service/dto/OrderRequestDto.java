package com.example.orderservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    private int orderId;
    private String orderNumber;
    private List<OrderLineItemRequestDto> orderLineItems;
}

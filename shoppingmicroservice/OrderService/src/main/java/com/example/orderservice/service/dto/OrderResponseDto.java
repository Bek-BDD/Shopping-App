package com.example.orderservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private int orderId;
    private String orderNumber;
    private List<OrderLineItemResponseDto> orderLineItems;
}

package com.example.orderservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemRequestDto {
    private int orderLineId;
    private int quantity;
    private String skuCode;
    private double price;
}

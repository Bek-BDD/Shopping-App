package com.example.orderservice.service;

import com.example.orderservice.service.dto.OrderRequestDto;
import com.example.orderservice.service.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {
    public OrderResponseDto addOrder(OrderRequestDto orderDto);
    public List<OrderResponseDto> getAllOrders();
    public OrderResponseDto getOrder(int o_id);
    public OrderResponseDto updateOrder(OrderRequestDto orderDto);
    public boolean deleteOrder(int o_id);
}

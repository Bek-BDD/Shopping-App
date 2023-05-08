package com.example.orderservice.service.Impl;

import com.example.orderservice.repository.OrderRepo;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.service.adapter.OrderMapper;
import com.example.orderservice.service.dto.OrderRequestDto;
import com.example.orderservice.service.dto.OrderResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepo orderRepo;
    protected OrderMapper orderMapper;

    @Override
    public OrderResponseDto addOrder(OrderRequestDto orderDto) {
        return null;
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return null;
    }

    @Override
    public OrderResponseDto getOrder(int o_id) {
        return null;
    }

    @Override
    public OrderResponseDto updateOrder(OrderRequestDto orderDto) {
        return null;
    }

    @Override
    public boolean deleteOrder(int o_id) {
        return false;
    }
}

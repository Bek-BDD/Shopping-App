package com.example.orderservice.service.adapter;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.dto.OrderRequestDto;
import com.example.orderservice.service.dto.OrderResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    public Order fromRequestDtotoDomain(OrderRequestDto orderDto);
    public List<Order> fromListOfRequestDtoToListOfDomain(List<OrderRequestDto> orderDtos);
    public OrderResponseDto fromDomainToResponseDto(Order order);
    public List<OrderResponseDto> fromListOfDomainToListOfResponseDto(List<Order> orders);
}

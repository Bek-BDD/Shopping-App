package com.example.orderservice.service.adapter;

import com.example.orderservice.model.OrderLineItem;
import com.example.orderservice.service.dto.OrderLineItemRequestDto;
import com.example.orderservice.service.dto.OrderLineItemResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderLineItemMapper {
    //OrderLineItemMapper INSTANCE = Mappers.getMapper(OrderLineItemMapper.class);
    @Mapping(target = "orderLineId", source = "orderLineItemDto.orderLineId")
    public OrderLineItem fromRequestDtoToDomain(OrderLineItemRequestDto orderLineItemDto);
    public OrderLineItemResponseDto fromOrderLineDomainToOrderLineResponseDto(OrderLineItem orderLineItem);
    public List<OrderLineItem> fromListOfOrderLineRequestDtoToListOfOrderLineDomain(List<OrderLineItemRequestDto> orderLineItemDtos);
    public List<OrderLineItemResponseDto> fromListOfOrderLineDomainToListOfOrderLineResponseDto(List<OrderLineItem> orderLineItems);
}

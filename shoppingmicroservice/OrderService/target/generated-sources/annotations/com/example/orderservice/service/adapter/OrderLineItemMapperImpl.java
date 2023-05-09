package com.example.orderservice.service.adapter;

import com.example.orderservice.model.OrderLineItem;
import com.example.orderservice.service.dto.OrderLineItemRequestDto;
import com.example.orderservice.service.dto.OrderLineItemResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T01:43:58-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class OrderLineItemMapperImpl implements OrderLineItemMapper {

    @Override
    public OrderLineItem fromRequestDtoToDomain(OrderLineItemRequestDto orderLineItemDto) {
        if ( orderLineItemDto == null ) {
            return null;
        }

        OrderLineItem orderLineItem = new OrderLineItem();

        orderLineItem.setOrderLineId( orderLineItemDto.getOrderLineId() );
        orderLineItem.setQuantity( orderLineItemDto.getQuantity() );
        orderLineItem.setSkuCode( orderLineItemDto.getSkuCode() );
        orderLineItem.setPrice( orderLineItemDto.getPrice() );

        return orderLineItem;
    }

    @Override
    public OrderLineItemResponseDto fromOrderLineDomainToOrderLineResponseDto(OrderLineItem orderLineItem) {
        if ( orderLineItem == null ) {
            return null;
        }

        OrderLineItemResponseDto orderLineItemResponseDto = new OrderLineItemResponseDto();

        orderLineItemResponseDto.setOrderLineId( orderLineItem.getOrderLineId() );
        orderLineItemResponseDto.setQuantity( orderLineItem.getQuantity() );
        orderLineItemResponseDto.setSkuCode( orderLineItem.getSkuCode() );
        orderLineItemResponseDto.setPrice( orderLineItem.getPrice() );

        return orderLineItemResponseDto;
    }

    @Override
    public List<OrderLineItem> fromListOfOrderLineRequestDtoToListOfOrderLineDomain(List<OrderLineItemRequestDto> orderLineItemDtos) {
        if ( orderLineItemDtos == null ) {
            return null;
        }

        List<OrderLineItem> list = new ArrayList<OrderLineItem>( orderLineItemDtos.size() );
        for ( OrderLineItemRequestDto orderLineItemRequestDto : orderLineItemDtos ) {
            list.add( fromRequestDtoToDomain( orderLineItemRequestDto ) );
        }

        return list;
    }

    @Override
    public List<OrderLineItemResponseDto> fromListOfOrderLineDomainToListOfOrderLineResponseDto(List<OrderLineItem> orderLineItems) {
        if ( orderLineItems == null ) {
            return null;
        }

        List<OrderLineItemResponseDto> list = new ArrayList<OrderLineItemResponseDto>( orderLineItems.size() );
        for ( OrderLineItem orderLineItem : orderLineItems ) {
            list.add( fromOrderLineDomainToOrderLineResponseDto( orderLineItem ) );
        }

        return list;
    }
}

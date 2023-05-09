package com.example.orderservice.service.adapter;

import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItem;
import com.example.orderservice.service.dto.OrderLineItemRequestDto;
import com.example.orderservice.service.dto.OrderLineItemResponseDto;
import com.example.orderservice.service.dto.OrderRequestDto;
import com.example.orderservice.service.dto.OrderResponseDto;
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
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order fromRequestDtoToDomain(OrderRequestDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setOrderId( orderDto.getOrderId() );
        order.setOrderNumber( orderDto.getOrderNumber() );
        order.setOrderLineItems( orderLineItemRequestDtoListToOrderLineItemList( orderDto.getOrderLineItems() ) );

        return order;
    }

    @Override
    public List<Order> fromListOfRequestDtoToListOfDomain(List<OrderRequestDto> orderDtos) {
        if ( orderDtos == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( orderDtos.size() );
        for ( OrderRequestDto orderRequestDto : orderDtos ) {
            list.add( fromRequestDtoToDomain( orderRequestDto ) );
        }

        return list;
    }

    @Override
    public OrderResponseDto fromDomainToResponseDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponseDto orderResponseDto = new OrderResponseDto();

        orderResponseDto.setOrderId( order.getOrderId() );
        orderResponseDto.setOrderNumber( order.getOrderNumber() );
        orderResponseDto.setOrderLineItems( orderLineItemListToOrderLineItemResponseDtoList( order.getOrderLineItems() ) );

        return orderResponseDto;
    }

    @Override
    public List<OrderResponseDto> fromListOfDomainToListOfResponseDto(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderResponseDto> list = new ArrayList<OrderResponseDto>( orders.size() );
        for ( Order order : orders ) {
            list.add( fromDomainToResponseDto( order ) );
        }

        return list;
    }

    protected OrderLineItem orderLineItemRequestDtoToOrderLineItem(OrderLineItemRequestDto orderLineItemRequestDto) {
        if ( orderLineItemRequestDto == null ) {
            return null;
        }

        OrderLineItem orderLineItem = new OrderLineItem();

        orderLineItem.setOrderLineId( orderLineItemRequestDto.getOrderLineId() );
        orderLineItem.setQuantity( orderLineItemRequestDto.getQuantity() );
        orderLineItem.setSkuCode( orderLineItemRequestDto.getSkuCode() );
        orderLineItem.setPrice( orderLineItemRequestDto.getPrice() );

        return orderLineItem;
    }

    protected List<OrderLineItem> orderLineItemRequestDtoListToOrderLineItemList(List<OrderLineItemRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderLineItem> list1 = new ArrayList<OrderLineItem>( list.size() );
        for ( OrderLineItemRequestDto orderLineItemRequestDto : list ) {
            list1.add( orderLineItemRequestDtoToOrderLineItem( orderLineItemRequestDto ) );
        }

        return list1;
    }

    protected OrderLineItemResponseDto orderLineItemToOrderLineItemResponseDto(OrderLineItem orderLineItem) {
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

    protected List<OrderLineItemResponseDto> orderLineItemListToOrderLineItemResponseDtoList(List<OrderLineItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderLineItemResponseDto> list1 = new ArrayList<OrderLineItemResponseDto>( list.size() );
        for ( OrderLineItem orderLineItem : list ) {
            list1.add( orderLineItemToOrderLineItemResponseDto( orderLineItem ) );
        }

        return list1;
    }
}

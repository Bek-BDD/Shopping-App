package com.example.orderservice.service.Impl;

import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItem;
import com.example.orderservice.repository.OrderRepo;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.service.adapter.OrderLineItemMapper;
import com.example.orderservice.service.adapter.OrderMapper;
import com.example.orderservice.service.dto.OrderRequestDto;
import com.example.orderservice.service.dto.OrderResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepo orderRepo;
    protected OrderMapper orderMapper;
    protected OrderLineItemMapper orderLineItemMapper;

    @Override
    public OrderResponseDto addOrder(OrderRequestDto orderDto) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItem> orderLineItems = orderLineItemMapper.fromListOfOrderLineRequestDtoToListOfOrderLineDomain(orderDto.getOrderLineItems());
        order.setOrderLineItems(orderLineItems);
        return orderMapper.fromDomainToResponseDto(orderRepo.save(order));
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return orderMapper.fromListOfDomainToListOfResponseDto(orderRepo.findAll());
    }

    @Override
    public OrderResponseDto getOrder(int o_id) {
        Optional<Order> order = orderRepo.findById(o_id);
       return order.map(o-> orderMapper.fromDomainToResponseDto(o)).orElse(null);
    }

    @Override
    public OrderResponseDto updateOrder(OrderRequestDto orderDto) {
        Optional<Order> oldOrder = orderRepo.findByOrderNumber(orderDto.getOrderNumber());

        if(oldOrder.isPresent()){
            Order orderInDb=oldOrder.get();
            orderInDb.setOrderLineItems(orderLineItemMapper.fromListOfOrderLineRequestDtoToListOfOrderLineDomain(orderDto.getOrderLineItems()));
            return orderMapper.fromDomainToResponseDto(orderRepo.save(orderInDb));
        }else{
            return orderMapper.fromDomainToResponseDto(orderRepo.save(orderMapper.fromRequestDtoToDomain(orderDto)));
        }
    }

    @Override
    public boolean deleteOrder(int o_id) {
        try{
            Optional<Order> order = orderRepo.findById(o_id);

            if(order.isPresent()){
                orderRepo.delete(order.get());
                return true;
            }else return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

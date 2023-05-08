package com.example.orderservice.controller;

import com.example.orderservice.repository.OrderRepo;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.service.dto.OrderRequestDto;
import com.example.orderservice.service.dto.OrderResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDto addOrder(@RequestBody OrderRequestDto orderDto){
        return orderService.addOrder(orderDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponseDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{o_id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponseDto getOrder(@PathVariable int o_id){
        return orderService.getOrder(o_id);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public OrderResponseDto updateOrder(@RequestBody OrderRequestDto orderDto){
        return orderService.updateOrder(orderDto);
    }

    @DeleteMapping("/{o_id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteOrder(@PathVariable int o_id){
        return orderService.deleteOrder(o_id);
    }

}

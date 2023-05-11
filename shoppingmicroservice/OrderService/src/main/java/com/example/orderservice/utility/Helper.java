package com.example.orderservice.utility;

import com.example.orderservice.exceptions.NotEnoughItemException;
import com.example.orderservice.model.OrderLineItem;
import com.example.orderservice.service.Impl.OrderServiceImpl;
import com.example.orderservice.service.adapter.OrderLineItemMapper;
import com.example.orderservice.service.dto.InventoryDto;
import com.example.orderservice.service.dto.OrderRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class Helper {

    private static InventoryClientService inventoryClientService;
    static protected OrderLineItemMapper orderLineItemMapper;

    public static void filterOrder(OrderRequestDto orderDto) throws NotEnoughItemException {
        List<OrderLineItem> orderLine = orderLineItemMapper.fromListOfOrderLineRequestDtoToListOfOrderLineDomain(orderDto.getOrderLineItems());
        List<OrderLineItem> outOfStockItems= orderLine.stream()
                .filter(o -> inventoryClientService.getInventory(o.getSkuCode()).getQuantity() < o.getQuantity()
                ).toList();
        if(outOfStockItems.size()>0){
            StringBuilder skuCodes =new StringBuilder();
            for (int i=0; i<outOfStockItems.size(); i++){
                skuCodes.append("Item").append(i).append(1).append(": ").append(outOfStockItems.get(i).getSkuCode()).append("-->");
            }
            throw new NotEnoughItemException("Items --- "+ skuCodes.toString() + "are out of Stock");
        }
    }

    @FeignClient("InventoryService")
    interface InventoryClientService{
        @GetMapping("/inventory")
        public InventoryDto getInventory(String skuCode);
    }
}

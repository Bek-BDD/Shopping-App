package com.example.inventoryservice.service;

import com.example.inventoryservice.service.Dto.InventoryRequestDto;
import com.example.inventoryservice.service.Dto.InventoryResponseDto;

import java.util.List;

public interface InventoryService {
    public InventoryResponseDto addInventory(InventoryRequestDto inventoryDto);
    public List<InventoryResponseDto> getAllInventory();
    public InventoryResponseDto getInventory(String skuCode);
    public boolean isInStock(String skuCode);
    public InventoryResponseDto updateInventory(InventoryRequestDto inventoryDto);
    public boolean deleteInventory(int inv_Id);


}

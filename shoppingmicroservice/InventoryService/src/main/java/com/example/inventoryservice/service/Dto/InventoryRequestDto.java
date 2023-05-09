package com.example.inventoryservice.service.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryRequestDto {
    private int id;
    private String skuCode;
    private int quantity;
}

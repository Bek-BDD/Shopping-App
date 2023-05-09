package com.example.inventoryservice.controller;

import com.example.inventoryservice.service.Dto.InventoryRequestDto;
import com.example.inventoryservice.service.Dto.InventoryResponseDto;
import com.example.inventoryservice.service.InventoryService;
import jakarta.ws.rs.POST;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@AllArgsConstructor
public class InventoryController {

    private InventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryResponseDto addInventory(@RequestBody InventoryRequestDto inventoryDto){
        return inventoryService.addInventory(inventoryDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponseDto> getAllInventory(){
        return inventoryService.getAllInventory();
    }
    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public InventoryResponseDto getInventory(@PathVariable String skuCode){
        return inventoryService.getInventory(skuCode);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public InventoryResponseDto updateInventory(@RequestBody InventoryRequestDto inventoryDto){
        return inventoryService.updateInventory(inventoryDto);
    }

    @DeleteMapping("/{inv_Id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteInventory(@PathVariable int inv_Id){
        return inventoryService.deleteInventory(inv_Id);
    }

}

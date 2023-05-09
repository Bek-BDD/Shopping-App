package com.example.inventoryservice.service.Impl;

import com.example.inventoryservice.domain.Inventory;
import com.example.inventoryservice.repository.InventoryRepo;
import com.example.inventoryservice.service.Dto.InventoryRequestDto;
import com.example.inventoryservice.service.Dto.InventoryResponseDto;
import com.example.inventoryservice.service.InventoryService;
import com.example.inventoryservice.service.adapter.InventoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class InventoryServiceImpl implements InventoryService {

    private InventoryRepo inventoryRepo;
    private InventoryMapper inventoryMapper;


    @Override
    public InventoryResponseDto addInventory(InventoryRequestDto inventoryDto) {
        return inventoryMapper.formInventoryDomainToResponseDto(inventoryRepo.save(inventoryMapper.fromRequestDtoToInventoryDomain(inventoryDto)));
    }

    @Override
    public List<InventoryResponseDto> getAllInventory() {
        return inventoryMapper.formListOfInventoryDomainToListOfResponseDto(inventoryRepo.findAll());
    }

    @Override
    public InventoryResponseDto getInventory(String skuCode) {
        Optional<Inventory> inventory = inventoryRepo.findBySkuCode(skuCode);
        return inventory.map(inv->inventoryMapper.formInventoryDomainToResponseDto(inv)).orElse(null);
    }

    @Override
    public boolean isInStock(String skuCode){
        return inventoryRepo.findBySkuCode(skuCode).isPresent();
    }

    @Override
    public InventoryResponseDto updateInventory(InventoryRequestDto inventoryDto) {
        Optional<Inventory> oldInventory = inventoryRepo.findById(inventoryDto.getId());
        if(oldInventory.isPresent()){
            Inventory updatedInventory =oldInventory.get();
            updatedInventory.setQuantity(inventoryDto.getQuantity());
            return inventoryMapper.formInventoryDomainToResponseDto(inventoryRepo.save(updatedInventory));
        }else {
            return inventoryMapper.formInventoryDomainToResponseDto(inventoryRepo.save(inventoryMapper.fromRequestDtoToInventoryDomain(inventoryDto)));
        }

    }

    @Override
    public boolean deleteInventory(int inv_Id) {
        Optional<Inventory> inventory = inventoryRepo.findById(inv_Id);

        try{
            if(inventory.isPresent()){
                inventoryRepo.delete(inventory.get());
                return true;
            }else return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
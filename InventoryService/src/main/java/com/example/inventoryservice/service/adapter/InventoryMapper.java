package com.example.inventoryservice.service.adapter;

import com.example.inventoryservice.domain.Inventory;
import com.example.inventoryservice.service.Dto.InventoryRequestDto;
import com.example.inventoryservice.service.Dto.InventoryResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    public Inventory fromRequestDtoToInventoryDomain(InventoryRequestDto inventoryDto);
    public InventoryResponseDto formInventoryDomainToResponseDto(Inventory inventory);
    public List<Inventory> fromListOfRequestDtoToListOfInventoryDomain(List<InventoryRequestDto> inventoryDto);
    public List<InventoryResponseDto> formListOfInventoryDomainToListOfResponseDto(List<Inventory> inventory);
}

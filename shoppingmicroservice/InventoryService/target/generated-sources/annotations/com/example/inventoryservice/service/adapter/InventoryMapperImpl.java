package com.example.inventoryservice.service.adapter;

import com.example.inventoryservice.domain.Inventory;
import com.example.inventoryservice.service.Dto.InventoryRequestDto;
import com.example.inventoryservice.service.Dto.InventoryResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T01:45:00-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class InventoryMapperImpl implements InventoryMapper {

    @Override
    public Inventory fromRequestDtoToInventoryDomain(InventoryRequestDto inventoryDto) {
        if ( inventoryDto == null ) {
            return null;
        }

        Inventory inventory = new Inventory();

        inventory.setId( inventoryDto.getId() );
        inventory.setSkuCode( inventoryDto.getSkuCode() );
        inventory.setQuantity( inventoryDto.getQuantity() );

        return inventory;
    }

    @Override
    public InventoryResponseDto formInventoryDomainToResponseDto(Inventory inventory) {
        if ( inventory == null ) {
            return null;
        }

        InventoryResponseDto inventoryResponseDto = new InventoryResponseDto();

        inventoryResponseDto.setId( inventory.getId() );
        inventoryResponseDto.setSkuCode( inventory.getSkuCode() );
        inventoryResponseDto.setQuantity( inventory.getQuantity() );

        return inventoryResponseDto;
    }

    @Override
    public List<Inventory> fromListOfRequestDtoToListOfInventoryDomain(List<InventoryRequestDto> inventoryDto) {
        if ( inventoryDto == null ) {
            return null;
        }

        List<Inventory> list = new ArrayList<Inventory>( inventoryDto.size() );
        for ( InventoryRequestDto inventoryRequestDto : inventoryDto ) {
            list.add( fromRequestDtoToInventoryDomain( inventoryRequestDto ) );
        }

        return list;
    }

    @Override
    public List<InventoryResponseDto> formListOfInventoryDomainToListOfResponseDto(List<Inventory> inventory) {
        if ( inventory == null ) {
            return null;
        }

        List<InventoryResponseDto> list = new ArrayList<InventoryResponseDto>( inventory.size() );
        for ( Inventory inventory1 : inventory ) {
            list.add( formInventoryDomainToResponseDto( inventory1 ) );
        }

        return list;
    }
}

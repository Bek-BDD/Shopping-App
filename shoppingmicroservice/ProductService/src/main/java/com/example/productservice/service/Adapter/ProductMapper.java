package com.example.productservice.service.Adapter;

import com.example.productservice.model.Product;
import com.example.productservice.service.Dto.ProductRequestDto;
import com.example.productservice.service.Dto.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  //  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(target = "id", source = "productDto.id", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "skuCode", source = "productDto.skuCode", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    Product formRequestDtoToProduct(ProductRequestDto productDto);
    @Mapping(target = "prodId", source = "product.id")
    ProductResponseDto fromProductToResponseDto(Product product);
    List<ProductResponseDto> fromProductListToResponseDtoList(List<Product> products);
}

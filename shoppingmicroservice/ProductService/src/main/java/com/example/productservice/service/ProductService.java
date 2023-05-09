package com.example.productservice.service;

import com.example.productservice.service.Dto.ProductRequestDto;
import com.example.productservice.service.Dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    public ProductResponseDto getProduct(String prod_id);
    public ProductResponseDto addProduct(ProductRequestDto productDto);
    public List<ProductResponseDto> getAllProducts();
    public ProductResponseDto updateProduct(ProductRequestDto productDto);
    public Boolean deleteProduct(String Prod_id);

}

package com.example.productservice.controller;

import com.example.productservice.service.Dto.ProductRequestDto;
import com.example.productservice.service.Dto.ProductResponseDto;
import com.example.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto productDto){
        return productService.addProduct(productDto);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{prod_id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto getProduct(@PathVariable String prod_id){
        return  productService.getProduct(prod_id);
    }

    @PatchMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto updateProduct(@RequestBody ProductRequestDto productDto){
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("/{prod_id}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean deleteProduct(@PathVariable String prod_id){
        return productService.deleteProduct(prod_id);
    }

}

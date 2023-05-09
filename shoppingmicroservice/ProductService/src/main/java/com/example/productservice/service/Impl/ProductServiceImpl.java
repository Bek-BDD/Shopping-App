package com.example.productservice.service.Impl;

import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepo;
import com.example.productservice.service.Dto.ProductRequestDto;
import com.example.productservice.service.Dto.ProductResponseDto;
import com.example.productservice.service.ProductService;
import com.example.productservice.service.Adapter.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;
    protected ProductMapper productMapper;
    @Override
    public ProductResponseDto addProduct(ProductRequestDto productDto) {

        return productMapper.fromProductToResponseDto(productRepo.save(productMapper.formRequestDtoToProduct(productDto)));
    }

    @Override
    public ProductResponseDto getProduct(String prod_id) {
        Optional<Product> product = productRepo.findById(prod_id);
        return product.map(value -> productMapper.fromProductToResponseDto(value)).orElse(null);
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productMapper.fromProductListToResponseDtoList(productRepo.findAll());
    }

    @Override
    public ProductResponseDto updateProduct(ProductRequestDto productDto) {
       Optional<Product> oldProduct = productRepo.findById(productDto.getId());

       if(oldProduct.isPresent()){
           Product productInDB= oldProduct.get();
           productInDB.setName(productDto.getName());
           productInDB.setDescription(productDto.getDescription());
           productInDB.setPrice(productDto.getPrice());

           return  productMapper.fromProductToResponseDto(productRepo.save(productInDB));
       }else return  productMapper.fromProductToResponseDto(productRepo.save(productMapper.formRequestDtoToProduct(productDto)));
    }

    @Override
    public Boolean deleteProduct(String prod_id) {
        try {
            Optional<Product> product = productRepo.findById(prod_id);
            if(product.isPresent()){
                productRepo.delete(product.get());
                return true;
            }else return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

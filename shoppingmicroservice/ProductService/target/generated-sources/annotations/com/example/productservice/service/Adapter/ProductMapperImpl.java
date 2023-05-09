package com.example.productservice.service.Adapter;

import com.example.productservice.model.Product;
import com.example.productservice.service.Dto.ProductRequestDto;
import com.example.productservice.service.Dto.ProductResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T01:45:34-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product formRequestDtoToProduct(ProductRequestDto product) {
        if ( product == null ) {
            return null;
        }

        Product product1 = new Product();

        if ( product.getId() != null ) {
            product1.setId( product.getId() );
        }
        else {
            product1.setId( java.util.UUID.randomUUID().toString() );
        }
        product1.setName( product.getName() );
        product1.setDescription( product.getDescription() );
        product1.setPrice( product.getPrice() );

        return product1;
    }

    @Override
    public ProductResponseDto fromProductToResponseDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setProdId( product.getId() );
        productResponseDto.setName( product.getName() );
        productResponseDto.setDescription( product.getDescription() );
        productResponseDto.setPrice( product.getPrice() );

        return productResponseDto;
    }

    @Override
    public List<ProductResponseDto> fromProductListToResponseDtoList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductResponseDto> list = new ArrayList<ProductResponseDto>( products.size() );
        for ( Product product : products ) {
            list.add( fromProductToResponseDto( product ) );
        }

        return list;
    }
}

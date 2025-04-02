package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.ProductDTO;
import com.devmaster.webbanhang.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toProductDTO(Product product);
    Product toProductEntity(ProductDTO productDTO);
}

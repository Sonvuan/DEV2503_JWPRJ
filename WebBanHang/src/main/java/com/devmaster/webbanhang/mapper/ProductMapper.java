package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.ProductDTO;
import com.devmaster.webbanhang.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    Product toProductEntity(ProductDTO dto);


    ProductDTO toProductDTO(Product entity);
}

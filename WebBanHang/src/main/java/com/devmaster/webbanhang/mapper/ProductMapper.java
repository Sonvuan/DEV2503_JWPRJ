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

    @Mapping(source = "category.id", target = "id_Category")
    Product toProductEntity(ProductDTO productDTO);
    @Mapping(source = "id_Category", target = "category.id")
    ProductDTO toProductDTO(Product product);
}


package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.Product_ImagesDTO;
import com.devmaster.webbanhang.entity.Product_Images;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface Product_ImagesMapper {
    Product_ImagesMapper INSTANCE = Mappers.getMapper(Product_ImagesMapper.class);

    @Mapping(source = "product.id", target = "id_Product")
    Product_ImagesDTO toProductImagesDTO(Product_Images product_Images);
    @Mapping(source = "id_Product", target = "product.id")
    Product_Images toProductImagesEntity(Product_ImagesDTO product_ImagesDTO);
}

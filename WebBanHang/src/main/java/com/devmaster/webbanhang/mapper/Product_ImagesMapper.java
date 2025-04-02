package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.Product_ImagesDTO;
import com.devmaster.webbanhang.entity.Product_Images;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface Product_ImagesMapper {
    Product_ImagesMapper INSTANCE = Mappers.getMapper(Product_ImagesMapper.class);

    Product_ImagesDTO toProductImagesDTO(Product_Images product_Images);
    Product_Images toProductImagesEntity(Product_ImagesDTO product_ImagesDTO);
}

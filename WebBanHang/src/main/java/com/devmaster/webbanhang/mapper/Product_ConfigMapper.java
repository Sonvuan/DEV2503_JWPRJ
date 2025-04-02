package com.devmaster.webbanhang.mapper;


import com.devmaster.webbanhang.dto.Product_ConfigDTO;
import com.devmaster.webbanhang.entity.Product_Config;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface Product_ConfigMapper {
    Product_ConfigMapper INSTANCE = Mappers.getMapper(Product_ConfigMapper.class);

    Product_ConfigDTO toProductConfigDTO(Product_Config product_config);
    Product_Config toProductConfigEntity(Product_ConfigDTO product_configDTO);
}

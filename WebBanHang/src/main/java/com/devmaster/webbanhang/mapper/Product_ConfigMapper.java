package com.devmaster.webbanhang.mapper;


import com.devmaster.webbanhang.dto.Product_ConfigDTO;
import com.devmaster.webbanhang.entity.Product_Config;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface Product_ConfigMapper {
    Product_ConfigMapper INSTANCE = Mappers.getMapper(Product_ConfigMapper.class);

    @Mapping(source = "product.id", target = "id_Product")
    @Mapping(source = "configuration.id", target = "id_Configuration")
    Product_ConfigDTO toProductConfigDTO(Product_Config product_config);
    @Mapping(source = "id_Product", target = "product.id")
    @Mapping(source = "id_Configuration", target = "configuration.id")
    Product_Config toProductConfigEntity(Product_ConfigDTO product_configDTO);
}

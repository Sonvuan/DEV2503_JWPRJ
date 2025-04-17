package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.Orders_DetailsDTO;
import com.devmaster.webbanhang.entity.Orders_Details;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface Orders_DetailsMapper {
    Orders_DetailsMapper INSTANCE = Mappers.getMapper(Orders_DetailsMapper.class);

    // Ánh xạ từ Orders_Details entity sang Orders_DetailsDTO
    @Mapping(source = "orders.id", target = "id_Order") // ánh xạ id sang id_Order
    @Mapping(source = "product.id", target = "id_Product") // ánh xạ id sản phẩm sang id_Product
    Orders_DetailsDTO toOrdersDetailsDTO(Orders_Details orders_details);

    // Ánh xạ từ Orders_DetailsDTO sang Orders_Details entity
    @Mapping(source = "id_Order", target = "orders.id") // ánh xạ id_Order sang id
    @Mapping(source = "id_Product", target = "product.id") // ánh xạ id_Product sang id sản phẩm
    Orders_Details toOrdersDetailsEntity(Orders_DetailsDTO orders_detailsDTO);
}

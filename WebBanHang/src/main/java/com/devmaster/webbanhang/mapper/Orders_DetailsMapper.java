package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.Orders_DetailsDTO;
import com.devmaster.webbanhang.entity.Orders_Details;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface Orders_DetailsMapper {
    Orders_DetailsMapper INSTANCE = Mappers.getMapper(Orders_DetailsMapper.class);

    Orders_DetailsDTO toOrdersDetailsDTO(Orders_Details orders_details);

    Orders_Details toOrdersDetailsEntity(Orders_DetailsDTO orders_detailsDTO);
}

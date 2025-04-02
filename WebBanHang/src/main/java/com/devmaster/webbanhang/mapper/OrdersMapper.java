package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.OrdersDTO;
import com.devmaster.webbanhang.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrdersMapper
{
    OrdersMapper INSTANCE = Mappers.getMapper(OrdersMapper.class);

    OrdersDTO toOrdersDTO(Orders orders);
    Orders toOrdersEn(OrdersDTO ordersDTO);
}

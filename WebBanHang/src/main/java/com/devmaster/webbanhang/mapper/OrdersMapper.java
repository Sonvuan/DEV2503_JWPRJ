package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.OrdersDTO;
import com.devmaster.webbanhang.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrdersMapper
{
    OrdersMapper INSTANCE = Mappers.getMapper(OrdersMapper.class);

    @Mapping(source = "customer.id", target = "id_Customer")
    @Mapping(source = "payment_method.id", target = "id_PaymentMethod")
    @Mapping(source = "transport_method.id", target = "id_TransportMethod")
    OrdersDTO toOrdersDTO(Orders orders);

    @Mapping(source = "id_Customer", target = "customer.id")
    @Mapping(source = "id_PaymentMethod", target = "payment_method.id")
    @Mapping(source = "id_TransportMethod", target = "transport_method.id")
    Orders toOrdersEntity(OrdersDTO ordersDTO);


}

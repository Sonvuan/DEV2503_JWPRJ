package com.devmaster.webbanhang.mapper;


import com.devmaster.webbanhang.dto.Payment_MethodDTO;
import com.devmaster.webbanhang.entity.Payment_Method;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface Payment_MethodMapper {
    Payment_MethodMapper INSTANCE = Mappers.getMapper(Payment_MethodMapper.class);

    Payment_MethodDTO toPaymentMethodDTO(Payment_Method payment_method);
    Payment_Method toPaymentMethodEntity(Payment_MethodDTO payment_methodDTO);
}

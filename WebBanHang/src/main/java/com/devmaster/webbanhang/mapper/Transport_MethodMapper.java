package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.Transport_MethodDTO;
import com.devmaster.webbanhang.entity.Transport_Method;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface Transport_MethodMapper {
    Transport_MethodMapper INSTANCE = Mappers.getMapper(Transport_MethodMapper.class);

    Transport_MethodDTO toTransportMethodDTO(Transport_Method transport_Method);
    Transport_Method toTransportMethodEntity(Transport_MethodDTO transport_MethodDTO);
}

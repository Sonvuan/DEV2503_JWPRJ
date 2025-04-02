package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.ConfigurationsDTO;
import com.devmaster.webbanhang.entity.Configurations;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ConfigurationsMapper {
    ConfigurationsMapper INSTANCE = Mappers.getMapper(ConfigurationsMapper.class);

    // chuyển từ dto sang entity
    ConfigurationsDTO toConfigDto(Configurations configurations);

    // chuyển từ entity sang dto
    Configurations toConfigEntity(ConfigurationsDTO configurationsDTO);
}

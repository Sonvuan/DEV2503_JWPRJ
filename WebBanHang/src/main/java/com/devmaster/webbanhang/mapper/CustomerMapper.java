package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.CustomerDTO;
import com.devmaster.webbanhang.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CustomerDTO toCustomerDTO(Customer customer);
    Customer toCustomerEntity(CustomerDTO customerDTO);
}

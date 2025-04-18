package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.CategoryDTO;
import com.devmaster.webbanhang.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CategoryMapper {

    // Tạo instance của mapper
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    // Ánh xạ từ Category sang CategoryDTO
    @Mapping(source = "parent.id", target = "idParent")
    CategoryDTO toCategoryDTO(Category category);

    // Ánh xạ từ CategoryDTO sang Category (nếu cần)
    @Mapping(source = "idParent", target = "parent.id")
    Category toCategoryEntity(CategoryDTO categoryDTO);

}

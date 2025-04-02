package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.CategoryDTO;
import com.devmaster.webbanhang.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Tạo instance của mapper
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    // Ánh xạ từ Category sang CategoryDTO
    CategoryDTO toCategoryDTO(Category category);

    // Ánh xạ từ CategoryDTO sang Category (nếu cần)
    Category toCategoryEntity(CategoryDTO categoryDTO);

}

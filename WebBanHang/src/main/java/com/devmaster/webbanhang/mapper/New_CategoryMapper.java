package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.News_CategoryDTO;
import com.devmaster.webbanhang.entity.News_Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface New_CategoryMapper {
    New_CategoryMapper INSTANCE = Mappers.getMapper(New_CategoryMapper.class);

    News_CategoryDTO toNew_CategoryDTO(News_Category news_Category);

    News_Category toNew_CategoryEntity(News_CategoryDTO news_CategoryDTO);
}

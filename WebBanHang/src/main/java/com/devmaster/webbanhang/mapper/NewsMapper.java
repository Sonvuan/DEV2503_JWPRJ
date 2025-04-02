package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.NewsDTO;
import com.devmaster.webbanhang.dto.News_CategoryDTO;
import com.devmaster.webbanhang.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    NewsDTO toNewsDTO(News news);

    News toNewsEntity(News_CategoryDTO news_CategoryDTO);
}

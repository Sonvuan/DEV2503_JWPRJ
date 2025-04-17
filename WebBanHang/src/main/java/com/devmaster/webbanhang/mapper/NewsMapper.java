package com.devmaster.webbanhang.mapper;

import com.devmaster.webbanhang.dto.NewsDTO;
import com.devmaster.webbanhang.dto.News_CategoryDTO;
import com.devmaster.webbanhang.entity.News;
import com.devmaster.webbanhang.entity.News_Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);


    @Mapping(source = "news_category.id", target = "idNews_Category")
    NewsDTO toNewsDTO(News news);

    @Mapping(source = "idNews_Category", target = "news_category.id")
    News toNewsEntity(NewsDTO newsDTO);



}

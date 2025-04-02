package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.News_Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface News_CategoryRepository extends JpaRepository<News_Category, Long> {
}

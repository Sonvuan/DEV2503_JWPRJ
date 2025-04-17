package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.News_Category;
import com.devmaster.webbanhang.entity.Product_Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface News_CategoryRepository extends JpaRepository<News_Category, Long> {
    @Query("SELECT p FROM News_Category p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<News_Category> findByName(String name);
}

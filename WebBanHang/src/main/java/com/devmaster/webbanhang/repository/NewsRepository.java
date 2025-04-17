package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.News;
import com.devmaster.webbanhang.entity.News_Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    @Query("SELECT p FROM News p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<News> findByName(String name);
}

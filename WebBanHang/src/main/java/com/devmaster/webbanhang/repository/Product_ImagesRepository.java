package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.Product_Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Product_ImagesRepository extends JpaRepository<Product_Images,Long> {
    @Query("SELECT p FROM Product_Images p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Product_Images> findByName(String name);
}

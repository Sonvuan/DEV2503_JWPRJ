package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.Product_Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_ImagesRepository extends JpaRepository<Product_Images,Long> {
}

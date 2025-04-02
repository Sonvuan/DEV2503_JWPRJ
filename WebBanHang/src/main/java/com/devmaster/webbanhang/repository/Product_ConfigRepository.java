package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.Product_Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_ConfigRepository extends JpaRepository<Product_Config, Integer> {
}

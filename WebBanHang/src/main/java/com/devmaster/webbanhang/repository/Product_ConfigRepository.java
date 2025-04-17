package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.Product_Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Product_ConfigRepository extends JpaRepository<Product_Config, Long> {

    @Query("SELECT pc FROM Product_Config pc WHERE pc.product.id = :id")
    List<Product_Config> findByProduct_Id(@Param("id") Long id);

    @Query("SELECT pc FROM Product_Config pc WHERE pc.configurations.id = :id")
    List<Product_Config> findByConfigurations_Id(@Param("id") Long id);


}

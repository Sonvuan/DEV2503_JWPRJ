package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.Configurations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigurationsRepository extends JpaRepository<Configurations, Long> {
    // tìm kiếm theo tên Config
    @Query("SELECT p FROM Configurations p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Configurations>findByName(String name);
}

package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.Configurations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationsRepository extends JpaRepository<Configurations, Long> {

}

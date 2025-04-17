package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.Customer;
import com.devmaster.webbanhang.entity.Transport_Method;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Transport_MethodRepository extends JpaRepository<Transport_Method, Long> {
    @Query("SELECT p FROM Transport_Method p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Transport_Method> findByName(String name);
}

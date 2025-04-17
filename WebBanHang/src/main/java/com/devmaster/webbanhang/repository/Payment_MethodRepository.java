package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.Customer;
import com.devmaster.webbanhang.entity.Payment_Method;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Payment_MethodRepository extends JpaRepository<Payment_Method, Long> {
    @Query("SELECT p FROM Payment_Method p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Payment_Method> findByName(String name);
}

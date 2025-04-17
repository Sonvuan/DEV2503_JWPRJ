package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.Customer;
import com.devmaster.webbanhang.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT p FROM Customer p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Customer> findByName(String name);
    @Query("SELECT p FROM Customer p WHERE LOWER(p.username) LIKE LOWER(CONCAT('%', :username, '%'))")
    List<Customer> findByUsername(String username);
}

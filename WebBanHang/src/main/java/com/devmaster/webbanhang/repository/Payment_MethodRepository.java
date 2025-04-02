package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.Payment_Method;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Payment_MethodRepository extends JpaRepository<Payment_Method, Long> {
}

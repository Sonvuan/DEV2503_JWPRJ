package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.Transport_Method;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Transport_MethodRepository extends JpaRepository<Transport_Method, Integer> {
}

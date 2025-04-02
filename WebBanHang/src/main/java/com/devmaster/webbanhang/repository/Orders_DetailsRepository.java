package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.Orders_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Orders_DetailsRepository extends JpaRepository<Orders_Details, Integer> {
}

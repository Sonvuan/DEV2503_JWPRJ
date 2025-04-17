package com.devmaster.webbanhang.repository;

import com.devmaster.webbanhang.entity.Orders;
import com.devmaster.webbanhang.entity.Orders_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Orders_DetailsRepository extends JpaRepository<Orders_Details, Long> {



    @Query("SELECT o FROM Orders_Details o WHERE o.orders.id = :id")
    List<Orders_Details> findByOrderId(@Param("id") Long orderId);

}

package com.devmaster.webbanhang.controller;

import com.devmaster.webbanhang.dto.Orders_DetailsDTO;
import com.devmaster.webbanhang.Service.Orders_DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders-details")
public class Orders_DetailsController {

    @Autowired
    private Orders_DetailsService ordersDetailsService;

    // ✅ Lấy tất cả chi tiết đơn hàng
    @GetMapping("/list")
    public ResponseEntity<List<Orders_DetailsDTO>> getAllOrdersDetails() {
        List<Orders_DetailsDTO> detailsList = ordersDetailsService.findAll();
        return new ResponseEntity<>(detailsList, HttpStatus.OK);
    }

    // ✅ Tìm chi tiết đơn hàng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Orders_DetailsDTO> getOrderDetailById(@PathVariable Long id) {
        Orders_DetailsDTO ordersDetails = ordersDetailsService.findById(id);
        return new ResponseEntity<>(ordersDetails, HttpStatus.OK);
    }

    // ✅ Lưu một dòng chi tiết đơn hàng
    @PostMapping("/create")
    public ResponseEntity<Orders_DetailsDTO> saveOrderDetail(@RequestBody Orders_DetailsDTO ordersDetailsDTO) {
        Orders_DetailsDTO savedDetails = ordersDetailsService.save(ordersDetailsDTO);
        return new ResponseEntity<>(savedDetails, HttpStatus.CREATED);
    }

    // ✅ Cập nhật chi tiết đơn hàng
    @PutMapping("/{id}")
    public ResponseEntity<Orders_DetailsDTO> updateOrderDetail(@PathVariable Long id, @RequestBody Orders_DetailsDTO ordersDetailsDTO) {
        Orders_DetailsDTO updatedDetails = ordersDetailsService.update(id, ordersDetailsDTO);
        return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
    }

    // ✅ Xóa chi tiết đơn hàng
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Long id) {
        ordersDetailsService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ✅ Lấy danh sách chi tiết đơn hàng theo OrderId
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<Orders_DetailsDTO>> getOrderDetailsByOrderId(@PathVariable Long orderId) {
        List<Orders_DetailsDTO> detailsList = ordersDetailsService.findByOrderId(orderId);
        return new ResponseEntity<>(detailsList, HttpStatus.OK);
    }

    // ✅ Lưu nhiều chi tiết đơn hàng và cập nhật tổng tiền
    @PostMapping("/bulk")
    public ResponseEntity<Void> saveOrderDetails(@RequestBody List<Orders_DetailsDTO> detailsList) {
        ordersDetailsService.saveOrderDetails(detailsList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

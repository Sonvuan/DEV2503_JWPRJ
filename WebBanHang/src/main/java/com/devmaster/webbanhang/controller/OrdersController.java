package com.devmaster.webbanhang.controller;

import com.devmaster.webbanhang.Service.OrdersService;
import com.devmaster.webbanhang.dto.OrdersDTO;
import com.devmaster.webbanhang.entity.Orders;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/list")
    public List<OrdersDTO> list(){
        return ordersService.fillAllOrders();
    }
    @PostMapping("/create")
    public ResponseEntity<OrdersDTO> create(@Valid @RequestBody OrdersDTO ordersDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(ordersService.create(ordersDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrdersDTO>update(@PathVariable Long id, @Valid @RequestBody OrdersDTO ordersDTO){
        return ResponseEntity.status(HttpStatus.OK).body(ordersService.update(id, ordersDTO));
    }
    @GetMapping("/search/id/{id}")
    public ResponseEntity<OrdersDTO> search(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(ordersService.getById(id));
    }
    @GetMapping("/search/idOrders/{id}")
    public ResponseEntity<List<OrdersDTO>> searchOrders(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(ordersService.getByIdOrders(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrdersDTO> delete(@PathVariable Long id){
        ordersService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

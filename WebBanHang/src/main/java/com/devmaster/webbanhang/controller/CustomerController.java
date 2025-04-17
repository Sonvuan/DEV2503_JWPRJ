package com.devmaster.webbanhang.controller;

import com.devmaster.webbanhang.Service.CustomerService;
import com.devmaster.webbanhang.dto.CustomerDTO;
import com.devmaster.webbanhang.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public List<CustomerDTO> getCustomers() {
       return customerService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerService.create(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer( @PathVariable Long id,@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updatedCustomer = customerService.update(id, customerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCustomer);
    }
    @GetMapping("/search/id/{id}")
    public ResponseEntity<CustomerDTO> searchCustomer(@PathVariable Long id) {
        CustomerDTO getId = customerService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(getId);
    }
    @GetMapping("/search/name/{name}")
    public List<CustomerDTO> searchName(@PathVariable String name) {
        return customerService.getByName(name);
    }
    @GetMapping("/search/username/{username}")
    public List<CustomerDTO> searchUsername(@PathVariable String username) {
        return customerService.getByUsername(username);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

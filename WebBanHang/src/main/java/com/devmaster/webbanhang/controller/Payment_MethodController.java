package com.devmaster.webbanhang.controller;

import com.devmaster.webbanhang.Service.Payment_MethodService;
import com.devmaster.webbanhang.dto.Payment_MethodDTO;
import com.devmaster.webbanhang.entity.Payment_Method;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class Payment_MethodController {
    @Autowired
    private Payment_MethodService payment_methodService;

    @GetMapping("/list")
    public List<Payment_MethodDTO> list(){
        return payment_methodService.findAll();
    }
    @PostMapping("/create")
    public ResponseEntity<Payment_MethodDTO> create(@Valid @RequestBody Payment_MethodDTO payment_MethodDTO){
        Payment_MethodDTO paymentMethodCreated = payment_methodService.create(payment_MethodDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentMethodCreated);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Payment_MethodDTO>update(@Valid @RequestBody Payment_MethodDTO payment_MethodDTO, @PathVariable Long id){
        Payment_MethodDTO paymentMethodUpdate = payment_methodService.update(id, payment_MethodDTO);
        return ResponseEntity.status(HttpStatus.OK).body(paymentMethodUpdate);
    }
    @GetMapping("/search/id/{id}")
    public ResponseEntity<Payment_MethodDTO> searchById(@PathVariable Long id){
        Payment_MethodDTO paymentMethodSearch = payment_methodService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(paymentMethodSearch);
    }
    @GetMapping("/search/name/{name}")
    public List<Payment_MethodDTO> searchByName(@PathVariable String name){
        return payment_methodService.getByName(name);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Payment_MethodDTO> delete(@PathVariable Long id){
        payment_methodService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

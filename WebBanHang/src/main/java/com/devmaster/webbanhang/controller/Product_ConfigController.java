package com.devmaster.webbanhang.controller;

import com.devmaster.webbanhang.Service.Product_ConfigService;
import com.devmaster.webbanhang.dto.Product_ConfigDTO;
import com.devmaster.webbanhang.entity.Product_Config;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pr_cf")
public class Product_ConfigController {
    @Autowired
    private Product_ConfigService product_configService;

    @GetMapping("/list")
    public List<Product_ConfigDTO> list(){
       return product_configService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Product_ConfigDTO> create(@Valid @RequestBody Product_ConfigDTO product_configDTO){
        Product_ConfigDTO product_config = product_configService.create(product_configDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product_config);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product_ConfigDTO> update(@Valid @RequestBody Product_ConfigDTO product_configDTO, @PathVariable Long id){
        Product_ConfigDTO product_config = product_configService.update(id, product_configDTO);
        return ResponseEntity.status(HttpStatus.OK).body(product_config);
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<Product_ConfigDTO> searchById(@PathVariable Long id){
        Product_ConfigDTO product_configDTO = product_configService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product_configDTO);
    }

    @GetMapping("/search/product/id/{id}")
    public List<Product_ConfigDTO> searchByProductId(@PathVariable Long id){
        return product_configService.searchProduct(id);
    }

    @GetMapping("/search/configs/id/{id}")
    public List<Product_ConfigDTO> searchByConfigId(@PathVariable Long id){
        return product_configService.searchConfig(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product_ConfigDTO> delete(@PathVariable Long id){
        product_configService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

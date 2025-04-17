package com.devmaster.webbanhang.controller;

import com.devmaster.webbanhang.Service.ProductService;
import com.devmaster.webbanhang.dto.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<ProductDTO> list(){
        return productService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDTO> add(@Valid @RequestBody ProductDTO productDTO){
        ProductDTO saveProduct = productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveProduct);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> update(@Valid @RequestBody ProductDTO productDTO, @PathVariable Long id){
        ProductDTO updateProduct = productService.updateProduct(id, productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<ProductDTO> searchId(@PathVariable Long id){
        ProductDTO search = productService.searchById(id);
        return ResponseEntity.status(HttpStatus.OK).body(search);
    }

    @GetMapping("/search/name/{name}")
    public List<ProductDTO> searchName(@PathVariable String name){
        return productService.searchByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductDTO> delete(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}

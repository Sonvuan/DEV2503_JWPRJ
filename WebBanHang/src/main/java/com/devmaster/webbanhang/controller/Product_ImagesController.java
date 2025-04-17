package com.devmaster.webbanhang.controller;

import com.devmaster.webbanhang.Service.Product_ImagesService;
import com.devmaster.webbanhang.dto.Product_ImagesDTO;
import com.devmaster.webbanhang.entity.Product_Images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pr_i")
public class Product_ImagesController {
    @Autowired
    private Product_ImagesService product_ImagesService;

    @GetMapping("/list")
    public List<Product_ImagesDTO> list() {
        return product_ImagesService.getProduct_Images();
    }

    @PostMapping("/create")
    public ResponseEntity<Product_ImagesDTO> create(@RequestBody Product_ImagesDTO product_imagesDTO) {
        Product_ImagesDTO productImagesDTO = product_ImagesService.create(product_imagesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productImagesDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product_ImagesDTO> update(@PathVariable Long id, @RequestBody Product_ImagesDTO product_imagesDTO) {
        Product_ImagesDTO productImagesDTO = product_ImagesService.update(id, product_imagesDTO);
        return ResponseEntity.status(HttpStatus.OK).body(productImagesDTO);
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<Product_ImagesDTO> search(@PathVariable Long id) {
        Product_ImagesDTO productImagesDTO = product_ImagesService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productImagesDTO);
    }

    @GetMapping("/search/name/{name}")
    public List<Product_ImagesDTO> searchByName(@PathVariable String name) {
        return product_ImagesService.getByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product_ImagesDTO> delete(@PathVariable Long id) {
        product_ImagesService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

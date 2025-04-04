package com.devmaster.webbanhang.controller;

import com.devmaster.webbanhang.Service.CategoryService;
import com.devmaster.webbanhang.dto.CategoryDTO;
import com.devmaster.webbanhang.entity.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public List<CategoryDTO> list() {
        return categoryService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping("/search/name/{name}")
    public List<CategoryDTO> search(@PathVariable String name) {
        return categoryService.getCategoryByName(name);
    }


    @GetMapping("/search/id/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        CategoryDTO categoryDTO = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryDTO);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDTO> update(@Valid @PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO updatedCategory = categoryService.updateCategory( id, categoryDTO);
        return ResponseEntity.ok(updatedCategory);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}

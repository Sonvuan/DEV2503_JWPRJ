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
        CategoryDTO savedCategory = categoryService.saveCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping("/search/{name}")
    public List<Category> search(@PathVariable String name) {
        return categoryService.getCategoryByName(name);
    }

    @PutMapping("/update/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        // Kiểm tra xem ID trong URL và trong đối tượng có khớp không
        if (!category.getId().equals(id)) {
            throw new IllegalArgumentException("ID trong URL và ID trong đối tượng không khớp!");
        }

        // Gọi service để cập nhật
        return categoryService.save(category);  // Truyền trực tiếp category vào service
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}

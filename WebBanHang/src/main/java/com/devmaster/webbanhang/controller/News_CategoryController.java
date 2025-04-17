package com.devmaster.webbanhang.controller;

import com.devmaster.webbanhang.Service.News_CategoryService;
import com.devmaster.webbanhang.dto.News_CategoryDTO;
import com.devmaster.webbanhang.entity.News_Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news_categoies")
public class News_CategoryController {
    @Autowired
    private News_CategoryService news_categoryService;

    @GetMapping("/list")
    public List<News_CategoryDTO> list() {
        return news_categoryService.getAllNews_Category();

    }

    @PostMapping("/create")
    public ResponseEntity <News_CategoryDTO> create(@Valid @RequestBody News_CategoryDTO news_categoryDTO) {
        News_CategoryDTO createdCategory = news_categoryService.create(news_categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<News_CategoryDTO> update(@Valid @RequestBody News_CategoryDTO news_categoryDTO, @PathVariable Long id) {
        News_CategoryDTO updateCategory = news_categoryService.update(id, news_categoryDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updateCategory);
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<News_CategoryDTO> searchById(@PathVariable Long id) {
        News_CategoryDTO searchId = news_categoryService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(searchId);
    }

    @GetMapping("/search/name/{name}")
    public List<News_CategoryDTO> searchByName(@PathVariable String name) {
        return news_categoryService.getByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<News_CategoryDTO> delete(@PathVariable Long id) {
        News_CategoryDTO deleteCategory = news_categoryService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(deleteCategory);
    }

}

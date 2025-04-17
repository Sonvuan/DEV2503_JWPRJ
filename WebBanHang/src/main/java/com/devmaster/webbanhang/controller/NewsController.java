package com.devmaster.webbanhang.controller;

import com.devmaster.webbanhang.Service.NewsService;
import com.devmaster.webbanhang.dto.NewsDTO;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/list")
    public List<NewsDTO> list(){
        return newsService.getAllNews();
    }

    @PostMapping("/create")
    public ResponseEntity<NewsDTO> create(@Valid @RequestBody NewsDTO newsDTO){
        NewsDTO newsCreated = newsService.create(newsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newsCreated);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<NewsDTO> update(@PathVariable Long id, @Valid @RequestBody NewsDTO newsDTO){
        NewsDTO newsUpdated = newsService.update(id, newsDTO);
        return ResponseEntity.status(HttpStatus.OK).body(newsUpdated);
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<NewsDTO> search(@PathVariable Long id){
        NewsDTO searchId = newsService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(searchId);
    }

    @GetMapping("/search/name/{name}")
    public List<NewsDTO> searchByName(@PathVariable String name){
        return newsService.getByName(name);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<NewsDTO> delete(@PathVariable Long id){
        newsService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

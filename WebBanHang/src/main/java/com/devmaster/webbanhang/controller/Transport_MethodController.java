package com.devmaster.webbanhang.controller;

import com.devmaster.webbanhang.Service.Transport_MethodService;
import com.devmaster.webbanhang.dto.Transport_MethodDTO;
import com.devmaster.webbanhang.entity.Transport_Method;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport")
public class Transport_MethodController {
    @Autowired
    private Transport_MethodService transport_MethodService;

    @GetMapping("/list")
    public List<Transport_MethodDTO> list(){
        return transport_MethodService.findAll();
    }
    @PostMapping("/create")
    public ResponseEntity<Transport_MethodDTO> create(@Valid @RequestBody Transport_MethodDTO transport_MethodDTO){
        Transport_MethodDTO transport_MethodCreate = transport_MethodService.create(transport_MethodDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(transport_MethodCreate);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Transport_MethodDTO> update(@Valid @RequestBody Transport_MethodDTO transport_MethodDTO, @PathVariable Long id){
        Transport_MethodDTO transport_MethodUpdate = transport_MethodService.update(id, transport_MethodDTO);
        return ResponseEntity.status(HttpStatus.OK).body(transport_MethodUpdate);
    }
    @GetMapping("/search/id/{id}")
    public ResponseEntity<Transport_MethodDTO> searchById(@PathVariable Long id){
        Transport_MethodDTO search = transport_MethodService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(search);
    }
    @GetMapping("/search/name/{name}")
    public List<Transport_MethodDTO> searchByName(@PathVariable String name){
        return transport_MethodService.getByName(name);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Transport_MethodDTO> delete(@PathVariable Long id){
        transport_MethodService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

package com.devmaster.webbanhang.controller;

import com.devmaster.webbanhang.Service.ConfigurationsService;
import com.devmaster.webbanhang.dto.ConfigurationsDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configs")
public class ConfigurationsController {
    @Autowired
    private ConfigurationsService configurationsService;

    @GetMapping("/list")
    public List<ConfigurationsDTO> getAllConfigurations() {
        return configurationsService.getAllConfigurations();
    }

    @PostMapping("/create")
    public ResponseEntity<ConfigurationsDTO> createConfiguration(@Valid @RequestBody ConfigurationsDTO configurationsDTO) {
        ConfigurationsDTO createdConfiguration = configurationsService.createConfiguration(configurationsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdConfiguration);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ConfigurationsDTO> updateConfiguration(@PathVariable Long id, @Valid @RequestBody ConfigurationsDTO configurationsDTO) {
        ConfigurationsDTO updatedConfiguration = configurationsService.updateConfiguration(id, configurationsDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedConfiguration);
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<ConfigurationsDTO> searchConfiguration(@PathVariable Long id) {
        ConfigurationsDTO searchById = configurationsService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(searchById);
    }

    @GetMapping("/search/name/{name}")
    public List<ConfigurationsDTO> searchConfigurationByName(@PathVariable String name) {
        return configurationsService.getConfigurationsByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ConfigurationsDTO> deleteConfiguration(@PathVariable Long id) {
        configurationsService.deleteConfiguration(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

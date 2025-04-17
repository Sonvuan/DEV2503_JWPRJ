package com.devmaster.webbanhang.Service;

import com.devmaster.webbanhang.dto.ConfigurationsDTO;
import com.devmaster.webbanhang.entity.Configurations;
import com.devmaster.webbanhang.entity.Configurations;
import com.devmaster.webbanhang.mapper.ConfigurationsMapper;
import com.devmaster.webbanhang.repository.ConfigurationsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConfigurationsService {
    @Autowired
    private ConfigurationsRepository configurationsRepository;
    @Autowired
    private ConfigurationsMapper configurationsMapper;

    //lấy danh sách
    public List<ConfigurationsDTO> getAllConfigurations() {
        return configurationsRepository.findAll()
                .stream().map(configurationsMapper::toConfigDto)
                .collect(Collectors.toList());
    }

    // tạo sản phẩm
    public ConfigurationsDTO createConfiguration(ConfigurationsDTO configurationsDTO) {
        Configurations configurations = configurationsMapper.toConfigEntity(configurationsDTO);
        return configurationsMapper.toConfigDto(configurationsRepository.save(configurations));
    }

    // sửa theo id
    public ConfigurationsDTO updateConfiguration(Long id,ConfigurationsDTO configurationsDTO) {
       if(!configurationsRepository.existsById(id)) {
           throw new EntityNotFoundException("id not found");
       }
       Configurations configurations = configurationsMapper.toConfigEntity(configurationsDTO);
       return configurationsMapper.toConfigDto(configurationsRepository.save(configurations));
    }

    // tìm kiếm theo id
    public ConfigurationsDTO getById(Long id) {
        Configurations configurations = configurationsRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Không tìm thấy id"));
        return configurationsMapper.toConfigDto(configurations);
    }

    // tìm kiếm theo tên
    public List<ConfigurationsDTO> getConfigurationsByName(String name) {
        return configurationsRepository.findByName(name)
                .stream().map(configurationsMapper::toConfigDto).collect(Collectors.toList());

    }

    // xoá
    public void deleteConfiguration(Long id) {
        configurationsRepository.deleteById(id);
    }
}

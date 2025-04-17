package com.devmaster.webbanhang.Service;

import com.devmaster.webbanhang.dto.Product_ConfigDTO;
import com.devmaster.webbanhang.entity.Product_Config;
import com.devmaster.webbanhang.mapper.Product_ConfigMapper;
import com.devmaster.webbanhang.repository.Product_ConfigRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Product_ConfigService {
    @Autowired
    private Product_ConfigRepository product_configRepository;
    @Autowired
    private Product_ConfigMapper product_configMapper;

    // lấy danh sách
    public List<Product_ConfigDTO> findAll() {
        return product_configRepository.findAll()
                .stream().map(product_configMapper::toProductConfigDTO)
                .collect(Collectors.toList());
    }


    //tạo mới
    public Product_ConfigDTO create(Product_ConfigDTO product_configDTO) {
        Product_Config product_config = product_configMapper.toProductConfigEntity(product_configDTO);
        return product_configMapper.toProductConfigDTO(product_configRepository.save(product_config));
    }

    // sửa
    public Product_ConfigDTO update(Long id, Product_ConfigDTO product_configDTO) {
        Optional<Product_Config> product_config = product_configRepository.findById(id);
        if (product_config.isPresent()) {
            Product_Config product_update = product_config.get();

            product_update.setValue(product_configDTO.getValue());

            return product_configMapper.toProductConfigDTO(product_configRepository.save(product_update));
        }
        throw new EntityNotFoundException("id không tồn tại");
    }

    // tìm kiếm theo id
    public Product_ConfigDTO getById(Long id) {
        Product_Config product_config = product_configRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("id không tồn tại"));
        return product_configMapper.toProductConfigDTO(product_config);
    }

    // tìm kiếm theo id product

    public List<Product_ConfigDTO> searchProduct(Long id) {
        return product_configRepository.findByProduct_Id(id)
                .stream().map(product_configMapper::toProductConfigDTO).collect(Collectors.toList());
    }

    // tìm kiếm theo id config
    public List<Product_ConfigDTO> searchConfig(Long id) {
        return product_configRepository.findByConfigurations_Id(id)
                .stream().map(product_configMapper::toProductConfigDTO).collect(Collectors.toList());
    }

    // xoá
    public void delete(Long id) {
        product_configRepository.deleteById(id);
    }
}

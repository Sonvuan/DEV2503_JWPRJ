package com.devmaster.webbanhang.Service;

import com.devmaster.webbanhang.dto.Product_ImagesDTO;
import com.devmaster.webbanhang.entity.Product_Images;
import com.devmaster.webbanhang.mapper.Product_ImagesMapper;
import com.devmaster.webbanhang.repository.Product_ImagesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Product_ImagesService {
    @Autowired
    private Product_ImagesRepository product_ImagesRepository;
    @Autowired
    private Product_ImagesMapper product_ImagesMapper;

    // lấy danh sách
    public List<Product_ImagesDTO> getProduct_Images(){
        return product_ImagesRepository.findAll()
                .stream().map(product_ImagesMapper::toProductImagesDTO).collect(Collectors.toList());
    }

    // tạo mới
    public Product_ImagesDTO create(Product_ImagesDTO product_ImagesDTO){
        Product_Images product_images = product_ImagesMapper.toProductImagesEntity(product_ImagesDTO);
        product_ImagesRepository.save(product_images);
        return product_ImagesMapper.toProductImagesDTO(product_images);
    }

    //sửa
    public Product_ImagesDTO update(Long id,Product_ImagesDTO product_ImagesDTO){
        Optional<Product_Images> product_images = product_ImagesRepository.findById(id);
        if(product_images.isPresent()){
            Product_Images productImageUpdate = product_images.get();

            productImageUpdate.setName(product_ImagesDTO.getName());
            productImageUpdate.setUrlimg(product_ImagesDTO.getUrlimg());


            return product_ImagesMapper.toProductImagesDTO(product_ImagesRepository.save(productImageUpdate));
        }

        throw new EntityNotFoundException("Id không tồn tại");
    }

    //tìm kiếm theo id
    public Product_ImagesDTO getById(Long id){
        Optional<Product_Images> product_images = product_ImagesRepository.findById(id);
        if(product_images.isPresent()){
            return product_ImagesMapper.toProductImagesDTO(product_images.get());
        }
        throw new EntityNotFoundException("Id không tồn tại");
    }

    // tìm kiếm theo tên
    public List<Product_ImagesDTO> getByName(String name){
        return product_ImagesRepository.findByName(name)
                .stream()
                .map(product_ImagesMapper::toProductImagesDTO)
                .collect(Collectors.toList());
    }

    // xoá
    public void delete(Long id){
        product_ImagesRepository.deleteById(id);
    }

}

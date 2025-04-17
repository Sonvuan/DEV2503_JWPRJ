package com.devmaster.webbanhang.Service;

import com.devmaster.webbanhang.dto.ProductDTO;
import com.devmaster.webbanhang.entity.Category;
import com.devmaster.webbanhang.entity.Product;
import com.devmaster.webbanhang.mapper.ProductMapper;
import com.devmaster.webbanhang.repository.CategoryRepository;
import com.devmaster.webbanhang.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    // lấy danh sách sản phẩm
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    // Thêm mới sản phẩm (kèm kiểm tra Category)
    public ProductDTO createProduct(ProductDTO productDTO) {
            Product product = productMapper.toProductEntity(productDTO);
            return productMapper.toProductDTO(productRepository.save(product));
    }


    // sửa sản phẩm

    public ProductDTO updateProduct(Long id ,ProductDTO productDTO) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
            
            productToUpdate.setName(productDTO.getName());
            productToUpdate.setDescription(productDTO.getDescription());
            productToUpdate.setPrice(productDTO.getPrice());
            productToUpdate.setQuantity(productDTO.getQuantity());
            productToUpdate.setContents(productDTO.getContents());
            productToUpdate.setImage(productDTO.getImage());
            productToUpdate.setNotes(productDTO.getNotes());

            productToUpdate.setMetaTitle(productDTO.getMetaTitle());
            productToUpdate.setSlug(productDTO.getSlug());
            productToUpdate.setMetaKeyword(productDTO.getMetaKeyword());
            productToUpdate.setMetaDescription(productDTO.getMetaDescription());
            productToUpdate.setUpdatedBy(productDTO.getUpdateBy());
            productToUpdate.setIsDelete(productDTO.getIsDelete());
            productToUpdate.setIsActive(productDTO.getIsActive());
            return productMapper.toProductDTO(productRepository.save(productToUpdate));
        }
        throw new EntityNotFoundException("Product không tồn tại với ID: " + id);
    }

    // tim kiem theo id
    public ProductDTO searchById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));

        return productMapper.toProductDTO(product);
    }

    // tìm kiem theo ten
    public List<ProductDTO> searchByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    // xoá
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

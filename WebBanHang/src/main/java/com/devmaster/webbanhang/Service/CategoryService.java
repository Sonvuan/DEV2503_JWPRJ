package com.devmaster.webbanhang.Service;

import com.devmaster.webbanhang.dto.CategoryDTO;
import com.devmaster.webbanhang.entity.Category;
import com.devmaster.webbanhang.entity.Category;
import com.devmaster.webbanhang.mapper.CategoryMapper;
import com.devmaster.webbanhang.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    // lấy ra danh sách category
    // Lấy danh sách category và chuyển đổi sang DTO
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toCategoryDTO) // Chuyển đổi từng phần tử sang DTO
                .collect(Collectors.toList()); // Thu thập kết quả thành danh sách
    }

    // thêm mới category
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toCategoryEntity(categoryDTO); // Chuyển từ DTO sang entity
        if (categoryDTO.getIdParent() != null) {
            Optional<Category> parentCategory = categoryRepository.findById(categoryDTO.getIdParent());
            parentCategory.ifPresent(category::setParent);
        } else {
            category.setParent(null);
        }

        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toCategoryDTO(savedCategory); // Chuyển từ entity sang DTO để trả về
    }


    // tìm kiêm theo ten category
    public List<CategoryDTO> getCategoryByName(String name) {

        return categoryRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(categoryMapper::toCategoryDTO) // Chuyển đổi từng phần tử sang DTO
                .collect(Collectors.toList()); // Thu thập kết quả thành danh sách
    }



    // tìm kiếm theo id category
    public CategoryDTO getCategoryById(Long id) {
        Category categorySearch = categoryRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("ID not found"));
        return categoryMapper.toCategoryDTO(categorySearch);
    }




    // chỉnh sửa category
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
            if(!categoryRepository.existsById(id)){
                throw new EntityNotFoundException("Id not found.");
            }
            Category categoryToUpdate = categoryMapper.toCategoryEntity(categoryDTO);
            if (categoryDTO.getIdParent() != null) {
                Optional<Category> parentCategory = categoryRepository.findById(categoryDTO.getIdParent());
                parentCategory.ifPresent(categoryToUpdate::setParent);
            } else {
                categoryToUpdate.setParent(null);
            }

        categoryToUpdate.setId(id);
            // Cập nhật ngày giờ tự động khi chỉnh sửa
            categoryToUpdate.setUpdatedDate(LocalDateTime.now());

            // Lưu lại
            Category updatedCategory = categoryRepository.save(categoryToUpdate);
            return categoryMapper.toCategoryDTO(updatedCategory);

    }



    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
  }

}

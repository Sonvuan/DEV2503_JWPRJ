package com.devmaster.webbanhang.Service;

import com.devmaster.webbanhang.dto.CategoryDTO;
import com.devmaster.webbanhang.entity.Category;
import com.devmaster.webbanhang.mapper.CategoryMapper;
import com.devmaster.webbanhang.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toCategoryEntity(categoryDTO); // Chuyển từ DTO sang entity
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toCategoryDTO(savedCategory); // Chuyển từ entity sang DTO để trả về
    }


    // tìm kiêm theo ten category
    public List<Category> getCategoryByName(String name) {
        return categoryRepository.findByNameContainingIgnoreCase(name);
    }

    // chỉnh sửa category
    public Category save(Category category) {
        Optional<Category> existingCategory = categoryRepository.findById(category.getId());
        if (existingCategory.isPresent()) {
            Category categoryToUpdate = existingCategory.get();

            // Cập nhật các trường cần thiết từ đối tượng gửi đến
            categoryToUpdate.setName(category.getName());
            categoryToUpdate.setIcon(category.getIcon());
            categoryToUpdate.setNotes(category.getNotes());
            categoryToUpdate.setMetaTitle(category.getMetaTitle());
            categoryToUpdate.setParentCategory(category.getParentCategory());
            categoryToUpdate.setSlug(category.getSlug());
            categoryToUpdate.setMetaKeyword(category.getMetaKeyword());
            categoryToUpdate.setMetaDescription(category.getMetaDescription());
            categoryToUpdate.setUpdateBy(category.getUpdateBy());
            categoryToUpdate.setIsDelete(category.getIsDelete());
            categoryToUpdate.setIsActive(category.getIsActive());

            // Cập nhật ngày giờ tự động khi chỉnh sửa
            categoryToUpdate.setUpdateDate(LocalDateTime.now());

            // Lưu lại đối tượng đã được cập nhật
            return categoryRepository.save(categoryToUpdate); // Phương thức này sẽ chỉ cập nhật đối tượng có ID tồn tại
        }
        return null; // Trả về null nếu không tìm thấy đối tượng cần cập nhật
    }


    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
  }

}

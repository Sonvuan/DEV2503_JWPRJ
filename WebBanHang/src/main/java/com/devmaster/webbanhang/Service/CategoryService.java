package com.devmaster.webbanhang.Service;

import com.devmaster.webbanhang.dto.CategoryDTO;
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
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toCategoryDTO(savedCategory); // Chuyển từ entity sang DTO để trả về
    }


    // tìm kiêm theo ten category
    public List<CategoryDTO> getCategoryByName(String name) {
//        List<Category> categories = categoryRepository.findByNameContainingIgnoreCase(name);
//        if (!categories.isEmpty()) {
//            // Duyệt qua danh sách và chuyển đổi mỗi Category thành CategoryDTO
//            List<CategoryDTO> categoryDTOs = new ArrayList<>();
//            for (Category category : categories) {
//                categoryDTOs.add(categoryMapper.toCategoryDTO(category)); // Chuyển Category thành CategoryDTO
//            }
//            return categoryDTOs; // Trả về danh sách CategoryDTO
//        } else {
//            throw new EntityNotFoundException("Category with name '" + name + "' not found.");
//        }

        return categoryRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(categoryMapper::toCategoryDTO) // Chuyển đổi từng phần tử sang DTO
                .collect(Collectors.toList()); // Thu thập kết quả thành danh sách
    }



    // tìm kiếm theo id category
    public CategoryDTO getCategoryById(Long id) {
        Optional<Category> categoryOpt = categoryRepository.findById(id);

        // Kiểm tra nếu category tồn tại
        if (categoryOpt.isPresent()) {
            Category category = categoryOpt.get();
            return categoryMapper.toCategoryDTO(category); // Chuyển đối tượng Category sang CategoryDTO nếu cần
        } else {
            throw new EntityNotFoundException("Category with ID " + id + " not found.");
        }
    }




    // chỉnh sửa category
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Optional<Category> existingCategory = categoryRepository.findById(id);

        if (existingCategory.isPresent()) {
            Category categoryToUpdate = existingCategory.get();

            // Cập nhật thông tin từ categoryDTO
            categoryToUpdate.setName(categoryDTO.getName());
            categoryToUpdate.setIcon(categoryDTO.getIcon());
            categoryToUpdate.setNotes(categoryDTO.getNotes());
            categoryToUpdate.setMetaTitle(categoryDTO.getMetaTitle());
            categoryToUpdate.setSlug(categoryDTO.getSlug());
            categoryToUpdate.setMetaKeyword(categoryDTO.getMetaKeyword());
            categoryToUpdate.setMetaDescription(categoryDTO.getMetaDescription());
            categoryToUpdate.setUpdatedBy(categoryDTO.getUpdateBy());
            categoryToUpdate.setIsDelete(categoryDTO.getIsDelete());
            categoryToUpdate.setIsActive(categoryDTO.getIsActive());

            // Cập nhật ngày giờ tự động khi chỉnh sửa
            categoryToUpdate.setUpdatedDate(LocalDateTime.now());

            // Lưu lại
            Category updatedCategory = categoryRepository.save(categoryToUpdate);
            return categoryMapper.toCategoryDTO(updatedCategory);
        }

        throw new EntityNotFoundException("Category không tồn tại với ID: " + id);
    }



    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
  }

}

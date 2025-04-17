package com.devmaster.webbanhang.Service;

import com.devmaster.webbanhang.dto.News_CategoryDTO;
import com.devmaster.webbanhang.entity.News_Category;
import com.devmaster.webbanhang.mapper.New_CategoryMapper;
import com.devmaster.webbanhang.repository.News_CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class News_CategoryService {
    @Autowired
    private News_CategoryRepository news_CategoryRepository;
    @Autowired
    private New_CategoryMapper new_CategoryMapper;

    // lấy danh sách
    public List<News_CategoryDTO> getAllNews_Category() {
        return news_CategoryRepository.findAll()
                .stream().map(new_CategoryMapper::toNew_CategoryDTO).collect(Collectors.toList());
    }
    // tạo mới
    public News_CategoryDTO create(News_CategoryDTO news_CategoryDTO) {
        News_Category newsCategoryDTO = new_CategoryMapper.toNew_CategoryEntity(news_CategoryDTO);

        // Kiểm tra và gán danh mục cha nếu có idParent
        if (news_CategoryDTO.getIdParent() != null) {
            Optional<News_Category> parentCategory = news_CategoryRepository.findById(news_CategoryDTO.getIdParent());
            parentCategory.ifPresent(newsCategoryDTO::setParent);
        } else {
            newsCategoryDTO.setParent(null); // Nếu không có danh mục cha, gán null
        }

        // Lưu danh mục mới vào cơ sở dữ liệu
        news_CategoryRepository.save(newsCategoryDTO);
        return new_CategoryMapper.toNew_CategoryDTO(newsCategoryDTO);
    }


    // sửa
    public News_CategoryDTO update(Long id, News_CategoryDTO news_CategoryDTO) {

        if (!news_CategoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Id Not Found");
        }
            News_Category newsCategoryUpdate = new_CategoryMapper.toNew_CategoryEntity(news_CategoryDTO);
            newsCategoryUpdate.setUpdatedDate(LocalDateTime.now());
            // Gán lại danh mục cha nếu có idParent
            if (news_CategoryDTO.getIdParent() != null) {
                Optional<News_Category> parentCategory = news_CategoryRepository.findById(news_CategoryDTO.getIdParent());
                parentCategory.ifPresent(newsCategoryUpdate::setParent);
            } else {
                newsCategoryUpdate.setParent(null); // nếu null thì xóa danh mục cha
            }

            // Lưu lại
            news_CategoryRepository.save(newsCategoryUpdate);

            return new_CategoryMapper.toNew_CategoryDTO(newsCategoryUpdate);

    }

    // tìm kiếm theo id
    public News_CategoryDTO getById(Long id) {
        Optional<News_Category> newsCategoryOpt = news_CategoryRepository.findById(id);
        if (newsCategoryOpt.isPresent()) {
            News_Category newsCategory = newsCategoryOpt.get();

            return new_CategoryMapper.toNew_CategoryDTO(newsCategory);
        }
        return null;
    }

    // tìm kiếm theo tên

    public List<News_CategoryDTO> getByName(String name) {
        return news_CategoryRepository.findByName(name)
                .stream().map(new_CategoryMapper::toNew_CategoryDTO).collect(Collectors.toList());
    }

    // xoá
    public void deleteById(Long id) {
        news_CategoryRepository.deleteById(id);
    }

}

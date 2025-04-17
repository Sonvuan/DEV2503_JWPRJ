package com.devmaster.webbanhang.Service;

import com.devmaster.webbanhang.dto.NewsDTO;
import com.devmaster.webbanhang.entity.News;
import com.devmaster.webbanhang.mapper.NewsMapper;
import com.devmaster.webbanhang.repository.NewsRepository;
import jakarta.persistence.Access;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private NewsMapper newsMapper;

    // lấy danh sách
    public List<NewsDTO> getAllNews(){
        return newsRepository.findAll()
                .stream().map(newsMapper::toNewsDTO).collect(Collectors.toList());
    }
    // tạo mới
    public NewsDTO create (NewsDTO newsDTO){
        News newsDto = newsMapper.toNewsEntity(newsDTO);

        newsRepository.save(newsDto);
        return newsMapper.toNewsDTO(newsDto);
    }
    // update
    public NewsDTO update(Long id, NewsDTO newsDTO) {
        News newsUpdate = newsMapper.toNewsEntity(newsDTO); // Convert full DTO -> Entity
        newsUpdate.setId(id); // Giữ nguyên ID

        // Set lại thời gian cập nhật nếu cần
        newsUpdate.setUpdatedDate(LocalDateTime.now());

        // (Optional) kiểm tra xem ID có tồn tại thật không trước khi lưu
        if (!newsRepository.existsById(id)) {
            throw new EntityNotFoundException("ID không tồn tại");
        }

        return newsMapper.toNewsDTO(newsRepository.save(newsUpdate));
    }


    // tìm kiếm theo id
    public NewsDTO getById (Long id){
        Optional<News> newsOptional = newsRepository.findById(id);
        if(newsOptional.isPresent()){
            News news = newsOptional.get();
            return newsMapper.toNewsDTO(news);
        }
        throw new EntityNotFoundException("ID không tồn tại");
    }

    // tìm kiếm theo tên
    public List<NewsDTO> getByName (String name){
        return newsRepository.findByName(name).stream().map(newsMapper::toNewsDTO).collect(Collectors.toList());
    }

    // xoá
    public void deleteById (Long id){
        newsRepository.deleteById(id);
    }
}

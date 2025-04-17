package com.devmaster.webbanhang.Service;

import com.devmaster.webbanhang.dto.Transport_MethodDTO;
import com.devmaster.webbanhang.entity.Transport_Method;
import com.devmaster.webbanhang.mapper.Transport_MethodMapper;
import com.devmaster.webbanhang.repository.Transport_MethodRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Transport_MethodService {
    @Autowired
    private Transport_MethodRepository transport_MethodRepository;
    @Autowired
    private Transport_MethodMapper transport_MethodMapper;

    // lấy danh sách
    public List<Transport_MethodDTO> findAll() {
        return transport_MethodRepository.findAll()
                .stream().map(transport_MethodMapper::toTransportMethodDTO).collect(Collectors.toList());
    }
    // tạo mới
    public Transport_MethodDTO create(Transport_MethodDTO transport_MethodDTO) {
        Transport_Method transport_MethodCreate = transport_MethodMapper.toTransportMethodEntity(transport_MethodDTO);
        return transport_MethodMapper.toTransportMethodDTO(transport_MethodRepository.save(transport_MethodCreate));
    }
    // sửa
    public Transport_MethodDTO update(Long id, Transport_MethodDTO transport_MethodDTO) {
        Transport_Method existing = transport_MethodRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id không tồn tại"));

        transport_MethodRepository.save(existing);
        return transport_MethodMapper.toTransportMethodDTO(existing);
    }

    // tìm kiếm id
    public Transport_MethodDTO getById(Long id) {
        Transport_Method transport_Method = transport_MethodRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Id không tồn tại"));
        return transport_MethodMapper.toTransportMethodDTO(transport_Method);
    }
    // tìm kiếm theo tên
    public List<Transport_MethodDTO> getByName(String name) {
        return transport_MethodRepository.findByName(name)
                .stream().map(transport_MethodMapper::toTransportMethodDTO).collect(Collectors.toList());
    }

    // xoá
    public void delete(Long id) {
        if (!transport_MethodRepository.existsById(id)){
            throw new EntityNotFoundException("Id không tồn tại");
        }
        transport_MethodRepository.deleteById(id);
    }
}

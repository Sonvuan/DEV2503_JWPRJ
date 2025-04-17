package com.devmaster.webbanhang.Service;

import com.devmaster.webbanhang.dto.Payment_MethodDTO;
import com.devmaster.webbanhang.entity.Payment_Method;
import com.devmaster.webbanhang.mapper.Payment_MethodMapper;
import com.devmaster.webbanhang.repository.Payment_MethodRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Payment_MethodService {
    @Autowired
    private Payment_MethodRepository payment_methodRepository;
    @Autowired
    private Payment_MethodMapper payment_methodMapper;

    // lấy danh sách
    public List<Payment_MethodDTO> findAll() {
        return payment_methodRepository.findAll()
                .stream().map(payment_methodMapper::toPaymentMethodDTO).collect(Collectors.toList());
    }
    // tạo mới
    public Payment_MethodDTO create(Payment_MethodDTO payment_methodDTO) {
        Payment_Method payment_methodCreate = payment_methodMapper.toPaymentMethodEntity(payment_methodDTO);
        Payment_Method payment_methodSave = payment_methodRepository.save(payment_methodCreate);
        return payment_methodMapper.toPaymentMethodDTO(payment_methodSave);

    }
    // sửa
    public Payment_MethodDTO update(Long id,Payment_MethodDTO payment_methodDTO) {
        if (!payment_methodRepository.existsById(id)) {
            throw new EntityNotFoundException("Id không tồn tại");
        }
        Payment_Method payment_methodUpdate = payment_methodMapper.toPaymentMethodEntity(payment_methodDTO);
        payment_methodUpdate.setId(id);
        payment_methodUpdate.setName(payment_methodDTO.getName());
        payment_methodUpdate.setNotes(payment_methodDTO.getNotes());
        payment_methodUpdate.setIsActive(payment_methodDTO.getIsActive());
        payment_methodUpdate.setIsDelete(payment_methodDTO.getIsDelete());
        payment_methodUpdate.setUpdatedDate(LocalDateTime.now());
        return payment_methodMapper.toPaymentMethodDTO(payment_methodRepository.save(payment_methodUpdate));
    }
    // tìm kiếm
    public Payment_MethodDTO getById(Long id) {
        Payment_Method payment_method = payment_methodRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("id không tồn tại"));
        return payment_methodMapper.toPaymentMethodDTO(payment_method);
    }
    // tìm kiếm theo name
    public List<Payment_MethodDTO> getByName(String name) {
        return payment_methodRepository.findByName(name).stream().map(payment_methodMapper::toPaymentMethodDTO).collect(Collectors.toList());
    }
    // xoá
    public void delete(Long id) {
        payment_methodRepository.deleteById(id);
    }
}

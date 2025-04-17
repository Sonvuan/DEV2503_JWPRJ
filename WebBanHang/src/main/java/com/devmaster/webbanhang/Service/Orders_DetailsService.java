package com.devmaster.webbanhang.Service;

import com.devmaster.webbanhang.dto.Orders_DetailsDTO;
import com.devmaster.webbanhang.entity.Orders_Details;
import com.devmaster.webbanhang.mapper.Orders_DetailsMapper;
import com.devmaster.webbanhang.repository.OrdersRepository;
import com.devmaster.webbanhang.repository.Orders_DetailsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Orders_DetailsService {

    @Autowired
    private Orders_DetailsRepository ordersDetailsRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private Orders_DetailsMapper ordersDetailsMapper;

    double totalOrderMoney = 0;

    // ✅ Lấy tất cả chi tiết đơn hàng
    public List<Orders_DetailsDTO> findAll() {
        return ordersDetailsRepository.findAll()
                .stream()
                .map(ordersDetailsMapper::toOrdersDetailsDTO)
                .collect(Collectors.toList());
    }

    // ✅ Tìm chi tiết đơn hàng theo ID
    public Orders_DetailsDTO findById(Long id) {
        Orders_Details entity = ordersDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết đơn hàng ID: " + id));
        return ordersDetailsMapper.toOrdersDetailsDTO(entity);
    }

    // ✅ Lưu một dòng chi tiết đơn hàng
    public Orders_DetailsDTO save(Orders_DetailsDTO dto) {
        // Tính lại total
        dto.setTotal(dto.getPrice() * (dto.getQty() - dto.getReturnQty()));
        Orders_Details entity = ordersDetailsMapper.toOrdersDetailsEntity(dto);
        Orders_Details saved = ordersDetailsRepository.save(entity);
        return ordersDetailsMapper.toOrdersDetailsDTO(saved);
    }

    // ✅ Cập nhật chi tiết đơn hàng
    public Orders_DetailsDTO update(Long id, Orders_DetailsDTO dto) {
        if (!ordersDetailsRepository.existsById(id)) {
            throw new RuntimeException("Chi tiết đơn hàng không tồn tại");
        }
        dto.setTotal(dto.getPrice() * (dto.getQty() - dto.getReturnQty()));
        Orders_Details entity = ordersDetailsMapper.toOrdersDetailsEntity(dto);
        entity.setId(id);
        Orders_Details updated = ordersDetailsRepository.save(entity);
        return ordersDetailsMapper.toOrdersDetailsDTO(updated);
    }

    // ✅ Xóa chi tiết đơn hàng theo ID
    public void delete(Long id) {
        if (!ordersDetailsRepository.existsById(id)) {
            throw new RuntimeException("Không tồn tại chi tiết đơn hàng để xóa");
        }
        ordersDetailsRepository.deleteById(id);
    }

    // ✅ Lấy danh sách chi tiết đơn hàng theo OrderId
    public List<Orders_DetailsDTO> findByOrderId(Long orderId) {
        List<Orders_Details> list = ordersDetailsRepository.findByOrderId(orderId);
        return list.stream()
                .map(ordersDetailsMapper::toOrdersDetailsDTO)
                .collect(Collectors.toList());
    }

}

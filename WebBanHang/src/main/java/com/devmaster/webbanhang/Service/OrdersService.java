package com.devmaster.webbanhang.Service;

import com.devmaster.webbanhang.dto.OrdersDTO;
import com.devmaster.webbanhang.entity.Orders;
import com.devmaster.webbanhang.mapper.OrdersMapper;
import com.devmaster.webbanhang.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrdersMapper ordersMapper;

    // lấy danh sách
    public List<OrdersDTO> fillAllOrders() {
        return ordersRepository.findAll()
                .stream().map(ordersMapper::toOrdersDTO).collect(Collectors.toList());
    }
    // tạo mới
    public OrdersDTO create(OrdersDTO ordersDTO) {
        Orders ordersCreate = ordersMapper.toOrdersEntity(ordersDTO);
        return ordersMapper.toOrdersDTO(ordersRepository.save(ordersCreate));
    }
    // sửa
    public OrdersDTO update(Long id,OrdersDTO ordersDTO) {
        if(!ordersRepository.existsById(id)) {
            throw  new RuntimeException("Id Not Found");
        }
        Orders ordersUpdate = ordersMapper.toOrdersEntity(ordersDTO);
        ordersUpdate.setId(id);
        ordersUpdate.setOrderDate(LocalDateTime.now());
        return ordersMapper.toOrdersDTO(ordersRepository.save(ordersUpdate));
    }
    // tìm kiếm
    public OrdersDTO getById(Long id) {
        Orders ordersById = ordersRepository.findById(id).orElseThrow(()->new RuntimeException("ID not found"));
        return ordersMapper.toOrdersDTO(ordersById);
    }
    // tìm kiếm theo idOrders
    public List<OrdersDTO> getByIdOrders(Long id) {
        return ordersRepository.findByOrderId(id).stream().map(ordersMapper::toOrdersDTO).collect(Collectors.toList());
    }
    // xoá
    public void delete(Long id) {
        Orders ordersById = ordersRepository.findById(id).orElseThrow(()->new RuntimeException("ID not found"));
        ordersRepository.deleteById(ordersById.getId());
    }
}

package com.devmaster.webbanhang.Service;

import com.devmaster.webbanhang.dto.CustomerDTO;
import com.devmaster.webbanhang.entity.Customer;
import com.devmaster.webbanhang.mapper.CustomerMapper;
import com.devmaster.webbanhang.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    // lấy danh sách
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll()
                .stream().map(customerMapper::toCustomerDTO).collect(Collectors.toList());
    }
    // tạo mới
    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toCustomerEntity(customerDTO);
        return customerMapper.toCustomerDTO(customerRepository.save(customer));
    }
    // update
    public CustomerDTO update(Long id,CustomerDTO customerDTO) {
        Customer customerUpdate = customerMapper.toCustomerEntity(customerDTO);
        customerUpdate.setId(id);
        customerUpdate.setUpdatedDate(LocalDateTime.now());
        if (!customerRepository.existsById(id)){
            throw new EntityNotFoundException("ID không tồn tại");
        }
        return customerMapper.toCustomerDTO(customerRepository.save(customerUpdate));
    }

    // tìm kiếm theo id
    public CustomerDTO getById(Long id) {
        // Tìm khách hàng và ném ngoại lệ nếu không tìm thấy
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID không tồn tại"));

        return customerMapper.toCustomerDTO(customer);
    }

    // tìm kiếm theo name
    public List<CustomerDTO> getByName(String name) {
        return customerRepository.findByName(name)
                .stream().map(customerMapper::toCustomerDTO).collect(Collectors.toList());
    }
    // tìm kiếm theo username
    public List<CustomerDTO> getByUsername(String username) {
        return customerRepository.findByUsername(username)
                .stream().map(customerMapper::toCustomerDTO).collect(Collectors.toList());
    }

    // xoá
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

}

package com.iamsajan.app.service;

import com.iamsajan.app.dto.response.CustomerResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    CustomerResponseDto createCustomer(CustomerResponseDto customerResponseDto);

    Page<CustomerResponseDto> getAllCustomers(Pageable pageable);

    CustomerResponseDto updateCustomer(CustomerResponseDto customerResponseDto);

    void deleteCustomer(String id);
}

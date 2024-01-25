package com.iamsajan.app.service.impl;

import com.iamsajan.app.dto.response.CustomerResponseDto;
import com.iamsajan.app.model.Customer;
import com.iamsajan.app.repository.CustomerRepository;
import com.iamsajan.app.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponseDto createCustomer(CustomerResponseDto customerResponseDto) {
        log.info("Request to create customer {}", customerResponseDto);
        if (customerResponseDto == null) {
            log.warn("Customer request cannot be null !!!");
            throw new RuntimeException("Customer request cannot be null !!!");
        }
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString());
        customer.setUsername(customerResponseDto.getUsername());
        customer.setEmail(customerResponseDto.getEmail());
        customer.setPhone(customerResponseDto.getPhone());

        customerRepository.save(customer);
        return customerResponseMapper(customer);
    }

    @Override
    public Page<CustomerResponseDto> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable).map(
                customer -> CustomerResponseDto.builder()
                        .id(customer.getId())
                        .username(customer.getUsername())
                        .email(customer.getEmail())
                        .phone(customer.getPhone())
                        .build()
        );
    }

    @Override
    public CustomerResponseDto updateCustomer(CustomerResponseDto customerResponseDto) {
        log.info("Request to update customer {}", customerResponseDto);
        if (customerResponseDto == null) {
            log.warn("Customer request cannot be null !!!");
            throw new RuntimeException("Customer request cannot be null !!!");
        }

        if (customerResponseDto.getId() == null) {
            log.warn("Customer id cannot be null !!!");
            throw new RuntimeException("Customer id cannot be null !!!");
        }

        Customer customer = customerRepository.findById(customerResponseDto.getId())
                .orElseThrow(() -> new RuntimeException("Customer not found !!!"));

        customer.setUsername(customerResponseDto.getUsername());
        customer.setEmail(customerResponseDto.getEmail());
        customer.setPhone(customerResponseDto.getPhone());

        customerRepository.save(customer);
        return customerResponseMapper(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        log.info("Deleting customer with id {}", id);
        if (id == null) {
            log.warn("Customer id cannot be null !!!");
            throw new RuntimeException("Customer id cannot be null !!!");
        }
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findCustomerById(String customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found !!!"));
    }

    private CustomerResponseDto customerResponseMapper(Customer customer) {
        return CustomerResponseDto.builder()
                .id(customer.getId())
                .username(customer.getUsername())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }
}

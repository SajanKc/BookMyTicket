package com.iamsajan.app.controller;

import com.iamsajan.app.dto.response.CustomerResponseDto;
import com.iamsajan.app.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerResponseDto> createCustomer(CustomerResponseDto customerResponseDto) {
        log.info("Request to create customer {}", customerResponseDto);
        CustomerResponseDto customerResponseDto1 = customerService.createCustomer(customerResponseDto);
        return ResponseEntity.ok().body(customerResponseDto1);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers(Pageable pageable) {
        log.info("Request to get a page of Customers");
        Page<CustomerResponseDto> customerList = customerService.getAllCustomers(pageable);
        return ResponseEntity.ok().body(customerList.getContent());
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerResponseDto> updateCustomer(CustomerResponseDto customerResponseDto) {
        log.info("Request to update customer {}", customerResponseDto);
        CustomerResponseDto customerResponseDto1 = customerService.updateCustomer(customerResponseDto);
        return ResponseEntity.ok().body(customerResponseDto1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        log.info("Request to delete customer {}", id);
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}

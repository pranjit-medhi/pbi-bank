package com.main.controller;

import com.main.dto.CustomerDTO;
import com.main.entity.Customer;
import com.main.exception.GlobalException;
import com.main.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers()
    {
         List<CustomerDTO> allCustomer = customerService.getAllCustomer();
        return new ResponseEntity<>(allCustomer, HttpStatus.OK);
    }
    @GetMapping("/customers/:{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long customerId) throws GlobalException {
         CustomerDTO customerDto = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }
}

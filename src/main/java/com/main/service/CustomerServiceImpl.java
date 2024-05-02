package com.main.service;

import com.main.dto.CustomerDTO;
import com.main.entity.Customer;
import com.main.exception.GlobalException;
import com.main.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO getCustomer(Long customerId) throws GlobalException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new GlobalException("Customer not found"));
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setCustomerName(customer.getCustomerName());
        customerDTO.setEmailId(customer.getCustomerName());
        customerDTO.setDateOfBirth(customer.getDateOfBirth());
        return customerDTO;

    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return List.of();
    }
}

package com.main.service;

import com.main.dto.CustomerDTO;
import com.main.entity.Customer;
import com.main.exception.GlobalException;

import java.util.List;

public interface CustomerService {
    public CustomerDTO getCustomer(Long customerId) throws GlobalException;
    public List<CustomerDTO> getAllCustomer();
    public CustomerDTO addCustomer(CustomerDTO customerDto);
    public void deletCustomer(Long customerId) throws GlobalException;
}

package com.main.service;

import com.main.dto.CustomerDTO;
import com.main.entity.Customer;
import com.main.exception.GlobalException;
import com.main.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
         List<Customer> all = customerRepository.findAll();
        List<CustomerDTO> customerList = new ArrayList<>();

        all.forEach(customer -> {
             CustomerDTO customerDTO  = new CustomerDTO();
             customerDTO.setCustomerName(customer.getCustomerName());
             customerDTO.setCustomerId(customer.getCustomerId());
             customerDTO.setEmailId(customer.getEmailId());
             customerDTO.setDateOfBirth(customer.getDateOfBirth());

            customerList.add(customerDTO);
         });
    return customerList;
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDto) {
         Customer customer = new Customer();
        customer.setCustomerId(customerDto.getCustomerId());
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setEmailId(customer.getEmailId());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        Customer save = customerRepository.save(customer);
        return customerDto;
    }

    @Override
    public void deletCustomer(Long customerId) throws GlobalException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new GlobalException("Customer not found"));
        customerRepository.delete(customer);
    }
}

package com.main.controller;

import com.main.dto.CustomerDTO;
import com.main.entity.Customer;
import com.main.exception.GlobalException;
import com.main.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Validated
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
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable @Min(value = 1, message = "Customer id should be between 1 and 100")
                                                           @Max(value = 100, message = "Customer id should be between 1 and 100") Long customerId) throws GlobalException {

        try {
            CustomerDTO customerDto = customerService.getCustomer(customerId);
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerDTO> addCustomer(@Valid  @RequestBody CustomerDTO customer)
    {
        try {
            CustomerDTO customerDTO = customerService.addCustomer(customer);
            return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
        }
        catch (Exception exception)
        {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
        }
    }
    @DeleteMapping("/customer/:{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) throws GlobalException {
        customerService.deletCustomer(customerId);
        return new ResponseEntity<>("Customer Deleted", HttpStatus.NO_CONTENT);
    }

}

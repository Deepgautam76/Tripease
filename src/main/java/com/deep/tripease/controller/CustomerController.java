package com.deep.tripease.controller;

import com.deep.tripease.dto.request.CustomerRequest;
import com.deep.tripease.dto.response.CustomerResponse;
import com.deep.tripease.model.Customer;
import com.deep.tripease.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }

    @GetMapping("/get/customer-id/{id}")
    public CustomerResponse getCustomerById(@PathVariable(name = "id") int customerId)throws Exception{
        return customerService.getCustomerById(customerId);
    }

}

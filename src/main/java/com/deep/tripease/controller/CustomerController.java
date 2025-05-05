package com.deep.tripease.controller;

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
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping("/get/customer-id/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") int customerId)throws Exception{
        return customerService.getCustomerById(customerId);
    }

}

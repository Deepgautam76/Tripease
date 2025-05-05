package com.deep.tripease.service;

import com.deep.tripease.Exception.CustomerNotFoundException;
import com.deep.tripease.model.Customer;
import com.deep.tripease.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(int customerId) {
        Optional<Customer> customer=customerRepository.findById(customerId);
        if(customer.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer id");
        }
        else{
            return customer.get();
        }
    }
}

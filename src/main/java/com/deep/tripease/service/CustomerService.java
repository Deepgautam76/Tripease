package com.deep.tripease.service;

import com.deep.tripease.dto.request.CustomerRequest;
import com.deep.tripease.dto.response.CustomerResponse;
import com.deep.tripease.exception.CustomerNotFoundException;
import com.deep.tripease.model.Customer;
import com.deep.tripease.repository.CustomerRepository;
import com.deep.tripease.transformer.CustomerDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        // CustomerRequest dto to Customer entity Using transformer class
        Customer saveCustomer=CustomerDtoTransformer.CustomerRequestToCustomer(customerRequest);

        // Customer entity to customerResponse using DtoTransformer class
        Customer customer=customerRepository.save(saveCustomer);
        return CustomerDtoTransformer.CustomerToCustomerResponse(customer);
    }

    public CustomerResponse getCustomerById(int customerId) {
        Optional<Customer> customer1=customerRepository.findById(customerId);
        if(customer1.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer id");
        }

        return CustomerDtoTransformer.CustomerToCustomerResponse(customer1.get());

    }
}

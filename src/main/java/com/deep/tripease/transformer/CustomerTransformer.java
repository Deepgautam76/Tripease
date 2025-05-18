package com.deep.tripease.transformer;

import com.deep.tripease.dto.request.CustomerRequest;
import com.deep.tripease.dto.response.CustomerResponse;
import com.deep.tripease.model.Customer;

public class CustomerTransformer {

    public static Customer CustomerRequestToCustomer(CustomerRequest customerRequest){
        Customer saveCustomer=new Customer();
        saveCustomer.setName(customerRequest.getName());
        saveCustomer.setAge(customerRequest.getAge());
        saveCustomer.setGender(customerRequest.getGender());
        saveCustomer.setEmailId(customerRequest.getEmailId());
        return saveCustomer;
    }
    public static CustomerResponse CustomerToCustomerResponse(Customer customer){

        CustomerResponse customerResponse=new CustomerResponse();
        customerResponse.setName(customer.getName());
        customerResponse.setAge(customer.getAge());
        customerResponse.setEmailId(customer.getEmailId());

        // This is the same task using Builder annotation
        return CustomerResponse
                .builder()
                .name(customer.getName())
                .age(customer.getAge())
                .emailId(customer.getEmailId())
                .build();
    }

}

package com.deep.tripease.service;

import com.deep.tripease.dto.request.CustomerRequest;
import com.deep.tripease.dto.response.CustomerResponse;
import com.deep.tripease.enums.Gender;
import com.deep.tripease.exception.CustomerNotFoundException;
import com.deep.tripease.model.Customer;
import com.deep.tripease.repository.CustomerRepository;
import com.deep.tripease.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<CustomerResponse> addCustomer(CustomerRequest customerRequest) {
        // CustomerRequest dto to Customer entity Using transformer class
        Customer saveCustomer= CustomerTransformer.CustomerRequestToCustomer(customerRequest);

        // Customer entity to customerResponse using DtoTransformer class
        Customer customer=customerRepository.save(saveCustomer);
        return new ResponseEntity<>(CustomerTransformer.CustomerToCustomerResponse(customer), HttpStatus.CREATED);
    }

    public ResponseEntity<CustomerResponse> getCustomerById(int customerId) {
        Optional<Customer> customer1=customerRepository.findById(customerId);
        if(customer1.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer id");
        }

        return new ResponseEntity<>(CustomerTransformer.CustomerToCustomerResponse(customer1.get()),HttpStatus.OK);

    }

    public ResponseEntity<?> getCustomerByGender(Gender gender) {
        List<Customer> customerList=customerRepository.findByGender(gender);
        List<CustomerResponse> customerResponseList=new ArrayList<>();

        for(Customer customer:customerList){
            customerResponseList.add(CustomerTransformer.CustomerToCustomerResponse(customer));
        }
        return new ResponseEntity<>(customerResponseList,HttpStatus.OK);
    }

    public ResponseEntity<?> getCustomerByGenderAndAge(Gender gender, int age) {
        List<Customer> customerList=customerRepository.findByGenderAndAge(gender,age);
        List<CustomerResponse> customerResponseList=new ArrayList<>();
        for(Customer customer:customerList){
            customerResponseList.add(CustomerTransformer.CustomerToCustomerResponse(customer));
        }
        return new ResponseEntity<>(customerResponseList,HttpStatus.OK);
    }

    public ResponseEntity<?> getCustomerByGenderAndGraterThanAge(Gender gender, int age) {

        List<Customer> customerList=customerRepository.getCustomerByGenderAndGraterThanAge(gender,age);
        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer:customerList){
            customerResponses.add(CustomerTransformer.CustomerToCustomerResponse(customer));
        }

        return new ResponseEntity<>(customerResponses,HttpStatus.OK);
    }

    //Fetch record by Native SQL Query
    public ResponseEntity<?> getCustomerByGenderAndGraterThanAge(String gender, int age) {

        List<Customer> customerList=customerRepository.getCustomerByGenderAndGraterThanAge(gender,age);
        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer:customerList){
            customerResponses.add(CustomerTransformer.CustomerToCustomerResponse(customer));
        }

        return new ResponseEntity<>(customerResponses,HttpStatus.OK);
    }

    public ResponseEntity<List<CustomerResponse>> getAllCustomer() {
        List<Customer> customers=customerRepository.findAll();
        List<CustomerResponse> customerResponseList=new ArrayList<>();
        for(Customer customer:customers){
            customerResponseList.add(CustomerTransformer.CustomerToCustomerResponse(customer));
        }
        return new ResponseEntity<>(customerResponseList,HttpStatus.OK);

    }
}

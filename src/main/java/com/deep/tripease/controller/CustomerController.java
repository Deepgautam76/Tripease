package com.deep.tripease.controller;

import com.deep.tripease.dto.request.CustomerRequest;
import com.deep.tripease.dto.response.CustomerResponse;
import com.deep.tripease.enums.Gender;
import com.deep.tripease.service.CustomerService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);
    }

    @GetMapping("/get/customer-id/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable(name = "id") int customerId)throws Exception{
        return customerService.getCustomerById(customerId);
    }
    @GetMapping("/get/customer-gender")
    public ResponseEntity<?> getCustomerByGender(@PathParam("gender") Gender gender){
        return customerService.getCustomerByGender(gender);
    }

    @GetMapping("/get/customer-gender-age")
    public ResponseEntity<?> getCustomerByGenderAndAge(@PathParam("gender") Gender gender,
                                                 @PathParam("age") int age){
        return customerService.getCustomerByGenderAndAge(gender,age);
    }

    @GetMapping("/get/customer-gender-grater-age")
    public ResponseEntity<?> getCustomerGenderAndGraterThanAge(@PathParam("gender")Gender gender,
                                                               @PathParam("age")int age){
        return customerService.getCustomerByGenderAndGraterThanAge(gender,age);
    }

    // Fetch record by native query
    @GetMapping("/get/customer-gender-grater-than-age")
    public ResponseEntity<?> getCustomerGenderAndGraterThanAge(@PathParam("gender")String gender,
                                                               @PathParam("age")int age){
        return customerService.getCustomerByGenderAndGraterThanAge(gender,age);
    }

    //Update the Customer profile
    @PutMapping("/update")
    public ResponseEntity<String> updateUseProfile(@RequestBody CustomerRequest customerRequest){
       return customerService.updateCustomerProfile(customerRequest);
    }


}

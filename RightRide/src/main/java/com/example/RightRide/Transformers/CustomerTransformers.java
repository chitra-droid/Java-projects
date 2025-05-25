package com.example.RightRide.Transformers;

import com.example.RightRide.Entity.Customer;
import com.example.RightRide.DTO.Requests.CustomerRequest;
import com.example.RightRide.DTO.Responses.CustomerResponse;

public class CustomerTransformers {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setGender(customerRequest.getGender());
        customer.setAge(customerRequest.getAge());
        customer.setName(customerRequest.getName());
        customer.setEmailId(customerRequest.getEmailId());
        return customer;
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer){
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setGender(customer.getGender());
        customerResponse.setName(customer.getName());
        customerResponse.setAge(customer.getAge());
        return customerResponse;
    }
}

package com.example.RightRide.transformers;

import com.example.RightRide.Entity.Customer;
import com.example.RightRide.dto.Requests.CustomerRequest;
import com.example.RightRide.dto.Responses.CustomerResponse;

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

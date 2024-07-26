package com.example.RightRide.service;

import com.example.RightRide.Entity.Customer;
import com.example.RightRide.Enum.Gender;
import com.example.RightRide.dto.Requests.CustomerRequest;
import com.example.RightRide.dto.Responses.CustomerResponse;
import com.example.RightRide.repository.CustomerRepository;
import com.example.RightRide.transformers.CustomerTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class    CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = CustomerTransformers.customerRequestToCustomer(customerRequest);
        CustomerResponse customerResponse = CustomerTransformers.customerToCustomerResponse(customer);
        customerRepository.save(customer);

        return customerResponse;
    }

    public Customer getCustomer(String emailId) {

        return customerRepository.findByEmailId(emailId);


    }

    public List<Customer> getAllByGenderandAgeGreaterThan(String gender, int age) {
        return customerRepository.getAllByGenderandAgeGreaterThan(gender, age);
    }


    public List<CustomerResponse> getAllByAgeLesserThan(int age) {
        List<Customer> ageLesserThan = customerRepository.findByAgeLesserThan(age);

        List<CustomerResponse> CR = new ArrayList<>();

        for (Customer customer : ageLesserThan) {
           CR.add(CustomerTransformers.customerToCustomerResponse(customer));
        }
        if (CR.isEmpty()) {
            throw new RuntimeException("None Found!");
        }
        return CR;
    }

}

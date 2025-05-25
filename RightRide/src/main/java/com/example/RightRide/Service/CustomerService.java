package com.example.RightRide.Service;

import com.example.RightRide.Entity.Customer;
import com.example.RightRide.DTO.Requests.CustomerRequest;
import com.example.RightRide.DTO.Responses.CustomerResponse;
import com.example.RightRide.Repository.CustomerRepository;
import com.example.RightRide.Transformers.CustomerTransformers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class    CustomerService {


    private final CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = CustomerTransformers.customerRequestToCustomer(customerRequest);
        CustomerResponse customerResponse = CustomerTransformers.customerToCustomerResponse(customer);
        customerRepository.save(customer);

        return customerResponse;
    }

    public CustomerResponse getCustomer(String emailId) {

       Optional<Customer> customer = customerRepository.findByEmailId(emailId);
       if(customer.isEmpty()){
           throw new RuntimeException("Customer Doesn't exists!");
       }
       Customer cust = customer.get();
       return CustomerTransformers.customerToCustomerResponse(cust);

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

package com.example.RightRide.repository;

import com.example.RightRide.Entity.Customer;
import com.example.RightRide.Enum.Gender;
import com.example.RightRide.dto.Responses.CustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByEmailId(String emailId);

    @Query(value = "select * from customer where gender = :gender and age >= :age",nativeQuery = true)
    public List<Customer> getAllByGenderandAgeGreaterThan(String gender, int age);


    @Query(value = "select c from Customer c where c.age <= :age")
    List<Customer> findByAgeLesserThan(int age);
}

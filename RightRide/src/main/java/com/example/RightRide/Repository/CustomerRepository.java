package com.example.RightRide.Repository;

import com.example.RightRide.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    Optional<Customer> findByEmailId(String emailId);

    @Query(value = "select * from customer where gender = :gender and age >= :age",nativeQuery = true)
    public List<Customer> getAllByGenderandAgeGreaterThan(String gender, int age);


    @Query(value = "select c from Customer c where c.age <= :age")
    List<Customer> findByAgeLesserThan(int age);
}

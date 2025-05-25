package com.example.RightRide.Repository;


import com.example.RightRide.Entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Integer> {

    Driver findByMobileNo(long mobileNo);


}

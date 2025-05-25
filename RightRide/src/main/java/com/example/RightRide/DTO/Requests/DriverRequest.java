package com.example.RightRide.dto.Requests;

import com.example.RightRide.Entity.Cab;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverRequest {

    String name;
    int age;
    int drivingLicense;
    long mobileNo;
    CabRequest cabRequest;
}

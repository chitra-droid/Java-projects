package com.example.RightRide.DTO.Requests;

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
    int rating;
}

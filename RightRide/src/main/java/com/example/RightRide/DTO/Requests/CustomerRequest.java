package com.example.RightRide.DTO.Requests;

import com.example.RightRide.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {

     String name;

     int age;

     Gender gender;

     String emailId;
}

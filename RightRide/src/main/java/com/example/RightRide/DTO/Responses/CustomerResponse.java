package com.example.RightRide.DTO.Responses;

import com.example.RightRide.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse {


     String name;

     int age;

     Gender gender;
}
